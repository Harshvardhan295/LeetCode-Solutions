class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long[] rowSum = new long[m];
        long[] colSum = new long[n];

        //Fill rowSum and colSum
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowSum[i] += grid[i][j];
                colSum[j] += grid[i][j];
            }
        }

        //Prefix sum
        for (int i = 1; i < m; i++) {
            rowSum[i] += rowSum[i - 1];
        }
        for (int j = 1; j < n; j++) {
            colSum[j] += colSum[j - 1];
        }

        long total = rowSum[m - 1];
        //Check horizontal cuts
        for (int i = 0; i < m - 1; i++) {
            if (rowSum[i] == total - rowSum[i]) return true;
        }

        //Check vertical cuts
        for (int j = 0; j < n - 1; j++) {
            if (colSum[j] == total - colSum[j]) return true;
        }

        return false;
    }
}
