class Solution {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int[] arr = new int[rows + cols + 1];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int dist = Math.abs(i - rCenter) + Math.abs(j - cCenter);
                arr[dist + 1] += 1;
            }
        }
        
        for (int i = 1; i < arr.length; i++) {
            arr[i] += arr[i - 1];
        }
        
        int[][] ans = new int[rows * cols][];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int dist = Math.abs(i - rCenter) + Math.abs(j - cCenter);
                ans[arr[dist]] = new int[] { i, j };
                arr[dist]++;
            }
        }
        return ans;
    }
}
