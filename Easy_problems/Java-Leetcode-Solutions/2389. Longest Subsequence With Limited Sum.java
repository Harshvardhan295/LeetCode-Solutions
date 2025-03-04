class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);// Sorting
        for (int i = 1; i < nums.length; i++) {// prefix sum
            nums[i] += nums[i - 1];
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
        int low = 0, high = nums.length-1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (nums[mid] > queries[i]) {
                    high = mid - 1;
                } else {
                    ans[i] = Math.max(ans[i], mid + 1);
                    low = mid + 1;
                }
            }
        }
        return ans;
    }
}
