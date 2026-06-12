class Solution {
    // Returns the "better" pair: higher count first, then lower op
    public long[] fn(long[] a, long[] b) {
        if (a[0] != b[0]) return a[0] > b[0] ? a : b;
        return a[1] < b[1] ? a : b;
    }

    public long minIncrease(int[] nums) {
        int n = nums.length;
        long[] op = new long[n];

        for (int i = 1; i <= n - 2; i++) {
            long mx = Math.max(nums[i - 1], nums[i + 1]);
            op[i] = Math.max(0L, mx + 1 - nums[i]);
        }

        // dp[i] = {max special indices count, min op to achieve it}
        long[][] dp = new long[n][2];
        dp[0] = new long[]{0, 0};
        dp[1] = new long[]{0, 0};

        for (int i = 2; i < n; i++) {
            // Take index i-1 as a special index
            long[] take = {dp[i - 2][0] + 1, dp[i - 2][1] + op[i - 1]};
            // Don't take index i-1
            long[] dont = dp[i - 1];
            dp[i] = fn(dont, take);
        }

        return dp[n - 1][1];
    }
}
