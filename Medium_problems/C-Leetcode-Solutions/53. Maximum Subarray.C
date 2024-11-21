int maxSubArray(int* nums, int n) {
    int max = nums[0];
    int sum = nums[0];
    for (int i = 1; i < n; i++) {
        sum = (sum + nums[i] > nums[i]) ? sum + nums[i] : nums[i];
        if (sum > max) {
            max = sum;
        }
    }
    return max;
}
