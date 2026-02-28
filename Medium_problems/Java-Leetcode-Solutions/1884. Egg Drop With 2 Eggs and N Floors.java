class Solution {
    int[][] dp = new int[1001][3];
    
    int ok(int n, int eggs) {
        if (dp[n][eggs] != -1) return dp[n][eggs];

        if (n <= 1) return n;
        if (eggs == 1) return n;

        int mini = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            int breakCase = ok(i - 1, eggs - 1);
            int surviveCase = ok(n - i, eggs);
            int worstMoves = 1 + Math.max(breakCase, surviveCase);
            mini = Math.min(mini, worstMoves);
        }

        return dp[n][eggs] = mini;
    }

    public int twoEggDrop(int n) {
        for (int i = 0; i < 1001; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = -1;
            }
        }
        return ok(n, 2);
    }
}
