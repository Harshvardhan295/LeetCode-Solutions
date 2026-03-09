//Recursion
// TC = 2^n
// SC= n
class Solution {
    public int rec(int[] prices, int idx, int buy, int cap) {
        if (cap == 0 || idx == prices.length)
            return 0;

        int profit;
        if (buy == 1) {
            profit = Math.max(-prices[idx] + rec(prices, idx + 1, 0, cap),
                    0 + rec(prices, idx + 1, 1, cap));
        } else {
            profit = Math.max(prices[idx] + rec(prices, idx + 1, 1, cap - 1),
                    0 + rec(prices, idx + 1, 0, cap));
        }
        return profit;
    }

    public int maxProfit(int k, int[] prices) {
        return rec(prices, 0, 1, k);
    }
}
// Memoization
// more auxillary space..
class Solution {
    public int rec(int[] prices, int idx, int buy, int cap, int[][][] dp) {
        if (idx == prices.length || cap == 0) return 0;

        if (dp[idx][buy][cap] != -1) return dp[idx][buy][cap];

        int profit;

        if (buy == 1) {
            profit = Math.max(
                    -prices[idx] + rec(prices, idx + 1, 0, cap, dp),
                    rec(prices, idx + 1, 1, cap, dp));
        } else {
            profit = Math.max(
                    prices[idx] + rec(prices, idx + 1, 1, cap - 1, dp),
                    rec(prices, idx + 1, 0, cap, dp));
        }
        return dp[idx][buy][cap] = profit;
    }

    public int maxProfit(int k, int[] prices) {

        int n = prices.length;
        int[][][] dp = new int[n][2][k + 1];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < 2; j++)
                for (int l = 0; l <= k; l++)
                    dp[i][j][l] = -1;

        return rec(prices, 0, 1, k, dp);
    }
}
//Tabulation
class Solution {
    public int maxProfit(int k, int[] prices) {

        int n = prices.length;

        int[][][] dp = new int[n + 1][2][k + 1];

        for (int idx = n - 1; idx >= 0; idx--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= k; cap++) {

                    if (buy == 1) {
                        dp[idx][buy][cap] = Math.max(
                                -prices[idx] + dp[idx + 1][0][cap],
                                dp[idx + 1][1][cap]);
                    } 
                    else {
                        dp[idx][buy][cap] = Math.max(
                                prices[idx] + dp[idx + 1][1][cap - 1],
                                dp[idx + 1][0][cap]);
                    }

                }
            }
        }

        return dp[0][1][k];
    }
}
