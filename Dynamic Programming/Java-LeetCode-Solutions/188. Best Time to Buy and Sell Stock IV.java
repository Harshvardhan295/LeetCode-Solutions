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
