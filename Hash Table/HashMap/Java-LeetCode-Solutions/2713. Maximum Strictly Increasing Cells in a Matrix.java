class Solution {
    public int maxIncreasingCells(int[][] arr) {
        int m = arr.length, n = arr[0].length;
        Map<Integer, List<int[]>> map = new TreeMap<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = arr[i][j];
                if (!map.containsKey(val)) {
                    map.put(val, new ArrayList<int[]>());
                }
                map.get(val).add(new int[] { i, j });
            }
        }
        int[][] dp = new int[m][n];
        int[] res = new int[n + m];
        for (int a : map.keySet()) {
            for (int[] pos : map.get(a)) {
                int i = pos[0], j = pos[1];
                dp[i][j] = Math.max(res[i], res[m + j]) + 1;
            }
            for (int[] pos : map.get(a)) {
                int i = pos[0], j = pos[1];
                res[m + j] = Math.max(res[m + j], dp[i][j]);
                res[i] = Math.max(res[i], dp[i][j]);
            }
        }
        int ans = 0;
        for (int a : res)
            ans = Math.max(ans, a);
        return ans;
    }
}
