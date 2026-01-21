class Solution {
    public int[] bestTower(int[][] tower, int[] center, int radius) {
        int[] ans = new int[2];
        Arrays.fill(ans, -1);

        int maxF = Integer.MIN_VALUE;

        for (int i = 0; i < tower.length; i++) {
            int x = tower[i][0];
            int y = tower[i][1];
            int F = tower[i][2];

            int d = Math.abs(x - center[0]) + Math.abs(y - center[1]);

            if (d <= radius) {
                if (F > maxF) {
                    maxF = F;
                    ans[0] = x;
                    ans[1] = y;
                } 
                else if (F == maxF) {
                    // lexicographical comparison
                    if (x < ans[0] || (x == ans[0] && y < ans[1])) {
                        ans[0] = x;
                        ans[1] = y;
                    }
                }
            }
        }
        return ans;
    }
}
