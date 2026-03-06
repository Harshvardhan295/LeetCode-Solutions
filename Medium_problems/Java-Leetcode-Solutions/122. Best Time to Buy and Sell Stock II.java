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
//Tabulation
class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] dp = new int[n + 1][2];

        dp[n][0] = 0;
        dp[n][1] = 0;

        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {

                int profit;

                if (buy == 1) {
                    profit = Math.max(-prices[ind] + dp[ind + 1][0],
                                      dp[ind + 1][1]);
                } else {
                    profit = Math.max(prices[ind] + dp[ind + 1][1],
                                      dp[ind + 1][0]);
                }

                dp[ind][buy] = profit;
            }
        }

        return dp[0][1];
    }
}
