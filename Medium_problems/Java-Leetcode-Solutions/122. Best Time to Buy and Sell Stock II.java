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
