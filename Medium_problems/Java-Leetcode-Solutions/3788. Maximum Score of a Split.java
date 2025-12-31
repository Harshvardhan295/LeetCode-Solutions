class Solution {
    public long maximumScore(int[] nums) {
        int n = nums.length;
        long[] preSum = new long[n];
        long[] sufMin = new long[n];

        preSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }

        sufMin[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            sufMin[i] = Math.min(nums[i], sufMin[i + 1]);
        }

        long max = Long.MIN_VALUE;
        for (int i = 0; i < n-1; i++) {
            max = Math.max(max, preSum[i] - sufMin[i+1]);
        }

        return max;
    }
}
