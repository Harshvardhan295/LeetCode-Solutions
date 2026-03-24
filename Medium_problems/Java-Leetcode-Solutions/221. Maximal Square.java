class Solution {
    public int maximalSquare(char[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int[][] dp = new int[m][n];
        int area = 0;

        for (int i = 0; i < m; i++) {
            dp[i][n-1] = arr[i][n-1] - '0';
            area = Math.max(area, dp[i][n-1]);
        }

        for (int j = 0; j < n; j++) {
            dp[m-1][j] = arr[m-1][j] - '0';
            area = Math.max(area, dp[m-1][j]);
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if (arr[i][j] == '1') {
                    dp[i][j] = 1 + Math.min(dp[i][j + 1],
                            Math.min(dp[i + 1][j], dp[i + 1][j + 1]));
                    area = Math.max(area, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return area * area;
    }
}
