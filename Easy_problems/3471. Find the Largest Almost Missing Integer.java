class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;

        if (k == n) {
            int max = Integer.MIN_VALUE;
            for (int num : nums) {
                max = Math.max(max, num);
            }
            return max;
        }

        int[] freq = new int[51];
        for (int i = 0; i <= n - k; i++) {
            boolean[] seen = new boolean[51];
            for (int j = i; j < i + k; j++) {
                if (!seen[nums[j]]) {
                    seen[nums[j]] = true;
                    freq[nums[j]]++;
                }
            }
        }

        int ans = -1;

        for (int i = 0; i < n; i++) {
            if (freq[nums[i]] == 1) {
                ans = Math.max(ans, nums[i]);
            }
        }

        return ans;
    }
}
