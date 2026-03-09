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
