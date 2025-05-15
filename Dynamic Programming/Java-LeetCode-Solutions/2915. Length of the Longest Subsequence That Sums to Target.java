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
//Memoization
class Solution {
    public static int subset(int idx, List<Integer> nums, int target,int[][] dp) {
        if (target == 0) return 0; // target matched
        if (idx >= nums.size() || target< 0) return Integer.MIN_VALUE; // invalid subsequence
        if(dp[idx][target]!=-1) return dp[idx][target];

        int skip = subset(idx + 1, nums, target,dp); 
        int take = subset(idx + 1, nums, target - nums.get(idx),dp);
        if (take != Integer.MIN_VALUE) take += 1; // count the current element
        
        return dp[idx][target]=Math.max(take, skip);
    }
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int[][] dp=new int[nums.size()][target+1];
        for(int i=0;i< dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
        int ans= subset(0,nums,target,dp);
        return ans>0 ? ans:-1;
    }
}
