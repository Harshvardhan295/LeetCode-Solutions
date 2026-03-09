// Basic logic
class Solution {
    public int maxProfit(int[] prices) {
        // at max - 2 transactions
        // firstbuy -> first sell -> second buy -> second sell
        int fb = Integer.MIN_VALUE, fs = 0;
        int sb = Integer.MIN_VALUE, ss = 0;
        for (int i = 0; i < prices.length; i++) {
            fb = Math.max(fb, -prices[i]);
            fs = Math.max(fs, fb + prices[i]);
            sb = Math.max(sb, fs - prices[i]);
            ss = Math.max(ss, sb + prices[i]);
        }
        return ss;
    }
}
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

    public int maxProfit(int[] prices) {
        return rec(prices, 0, 1, 2);
    }
}
