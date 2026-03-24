class Solution {
    public int findLength(int[] X, int[] Y) {
        // Longest Common Substring logic
        int m = X.length;
        int n = Y.length;
        int[][] dp = new int[m + 1][n + 1];

        int maxLen = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                // If characters match
                if (X[i - 1] == Y[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];

                }
                // If not match → substring breaks
                else {
                    dp[i][j] = 0;
                }
                maxLen = Math.max(maxLen, dp[i][j]);
            }
        }

        return maxLen;
    }
}
