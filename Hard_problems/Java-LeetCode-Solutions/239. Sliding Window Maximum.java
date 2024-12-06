class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] maxarr = new int[nums.length - k + 1];
        
        for (int i = 0; i <= nums.length - k; i++) {
            int max = Integer.MIN_VALUE;
            
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            
            maxarr[i] = max;
        }
        
        return maxarr;
    }
}
