class Solution {
    public boolean canSortArray(int[] nums) {
        int n = nums.length;
        int i = 0;

        while (i < n) {
            int j = i;
            // find segment with same bit count
            while (j < n && Integer.bitCount(nums[j]) == Integer.bitCount(nums[i])) {
                j++;
            }
            // sort this segment
            Arrays.sort(nums, i, j);
            i = j;
        }

        for (int k = 1; k < n; k++) {
            if (nums[k] < nums[k - 1]) return false;
        }

        return true;
    }
}
