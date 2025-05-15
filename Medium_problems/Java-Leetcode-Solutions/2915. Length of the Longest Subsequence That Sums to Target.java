//Recursion
class Solution {
    public static int subset(int idx, List<Integer> nums, int C) {
        if (C == 0) return 0; // target matched
        if (idx >= nums.size() || C < 0) return Integer.MIN_VALUE; // invalid subsequence

        int skip = subset(idx + 1, nums, C); 
        int take = subset(idx + 1, nums, C - nums.get(idx));
        if (take != Integer.MIN_VALUE) take += 1; // count the current element
        
        return Math.max(take, skip);
    }
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        
        int ans= subset(0,nums,target);
        return ans>0 ? ans:-1;
    }
}
//
