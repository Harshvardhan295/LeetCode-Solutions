//Recursion
class Solution {
    public int ways(int i,int[] nums, int target){
        if(i==nums.length) return target==0 ? 1 : 0;
        int add=ways(i+1,nums,target-nums[i]);
        int sub=ways(i+1,nums,target+nums[i]);
        return add+sub;
    }
    public int findTargetSumWays(int[] nums, int target) {
        return ways(0,nums,target);
    }
}
//Memoization
class Solution {
    public int ways(int i,int[] nums, int target,int[][] dp,int sum,int ans){
        if(i==nums.length) return target==ans ? 1 : 0;
        if(dp[i][ans+sum]!=-1) return dp[i][ans+sum];
        int add=ways(i+1,nums,target,dp,sum,ans+nums[i]);
        int sub=ways(i+1,nums,target,dp,sum,ans-nums[i]);
        return dp[i][ans+sum]=add+sub;
    }
    public int findTargetSumWays(int[] nums, int target) {
        // i = 0 to n-1 and target = -sum to sum 
        int sum=0, n= nums.length, ans=0;
        for(int ele: nums) sum+=ele;
        int[][] dp=new int[n][2*sum+1];
        for(int i=0;i<dp.length;i++)
            for(int j=0;j<dp[0].length;j++) dp[i][j]=-1;
        return ways(0,nums,target,dp,sum,ans);
    }
}
//HashMap
class Solution {
    public int ways(int i, int[] nums, int target, Map<String, Integer> map, int ans) {
        if (i == nums.length) return target == ans ? 1 : 0;
        
        String key = i + "," + ans;
        if (map.containsKey(key)) return map.get(key);
        
        int add = ways(i + 1, nums, target, map, ans + nums[i]);
        int sub = ways(i + 1, nums, target, map, ans - nums[i]);
        
        map.put(key, add + sub);
        return map.get(key);
    }

    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> map = new HashMap<>();
        return ways(0, nums, target, map, 0);
    }
}
