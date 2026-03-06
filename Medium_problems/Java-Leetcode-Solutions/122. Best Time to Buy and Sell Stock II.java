//Recursion
// TC = 2^n
// SC= n
class Solution {
    int profit = 0;

    public int rec(int[] prices, int idx, int buy) {
        if (idx == prices.length)
            return 0;
        if (buy == 1) {
            profit = Math.max(-prices[idx] + rec(prices, idx + 1, 0),
                    0 + rec(prices, idx + 1, 1));
        } else {
            profit = Math.max(prices[idx] + rec(prices, idx + 1, 1),
                    0 + rec(prices, idx + 1, 0));
        }
        return profit;
    }

    public int maxProfit(int[] prices) {
        return rec(prices, 0, 1);
    }
}
// Memoization
// TC = 2n
// SC= 2n + n
class Solution {
    int profit = 0;

    public int rec(int[] prices, int idx, int buy, int[][] dp) {
        if (idx == prices.length)
            return 0;
        if(dp[idx][buy]!=-1) return dp[idx][buy];
        if (buy == 1) {
            profit = Math.max(-prices[idx] + rec(prices, idx + 1, 0, dp),
                    0 + rec(prices, idx + 1, 1, dp));
        } else {
            profit = Math.max(prices[idx] + rec(prices, idx + 1, 1, dp),
                    0 + rec(prices, idx + 1, 0, dp));
        }

        return dp[idx][buy]=profit;
    }

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for(int i=0;i<prices.length;i++)
            for(int j=0;j<2;j++)
                dp[i][j]=-1;
        return rec(prices, 0, 1, dp);
    }
}
