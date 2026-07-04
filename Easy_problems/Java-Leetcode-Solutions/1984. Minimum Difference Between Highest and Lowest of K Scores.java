class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int j = 0, i = 0;
        while (j < k) j++;
        
        int ans = nums[j-1] - nums[i];
        int n = nums.length;
        while (j < n) {
            if (j - i + 1 >= k) {
                i++;
                ans=Math.min(ans,nums[j]-nums[i]);
            }           
            j++;
        }
        return ans;
    }
}
