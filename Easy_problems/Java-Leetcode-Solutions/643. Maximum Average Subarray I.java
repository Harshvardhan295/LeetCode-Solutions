class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length, j = 0, i = 0;
        double maxAvg = Double.NEGATIVE_INFINITY;
        double sum = 0;
        while (j < n) {
            sum += nums[j];
            if ((j - i + 1) == k) {
                maxAvg = Math.max(maxAvg, sum / k);
            } else if ((j - i + 1) > k) {
                sum -= nums[i];
                i++;
                if ((j - i + 1) == k) {
                    maxAvg = Math.max(maxAvg, sum / k);
                }
            }
            j++;
        }
        return maxAvg;
    }
}
