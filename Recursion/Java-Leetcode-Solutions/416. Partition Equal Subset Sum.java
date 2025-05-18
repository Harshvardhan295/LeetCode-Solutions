//Recursion
class Solution {
    private static boolean Subset(int i, int[] nums, int c) {
        if(i==nums.length){
            return c == 0;
        }
        boolean skip= Subset(i+1,nums,c);
        if(c-nums[i]<0) return skip; //Only valid for +ve numbers
        boolean take = Subset(i + 1, nums, c - nums[i]);
        return take||skip;
    }
    public boolean canPartition(int[] nums) {
        int sum=0,c=Integer.MIN_VALUE;
        for(int ele:nums) {
            sum+=ele;
        }
        if(sum%2!=0) return false;//if array sum is odd, no two equal subsets can be created
        c=sum/2;
        return Subset(0,nums,c);
    }
}
//Memoization
class Solution {
    private static boolean subsetMemo(int i, int[] nums, int c, int[][] dp) {
        if(i==nums.length) return c == 0;

        if (dp[i][c] != -1) return (dp[i][c] == 1);
        boolean ans = false;
        boolean skip = subsetMemo(i + 1, nums, c, dp);
        if(c-nums[i]<0) return ans=skip;
        else{
            boolean take = subsetMemo(i + 1, nums, c - nums[i], dp);
            ans=take||skip;
        }
        if(ans) dp[i][c]=1;
        else dp[i][c]=0;
        return ans;
    }
    public boolean canPartition(int[] nums) {
        int sum=0,c=Integer.MIN_VALUE;
        for(int ele:nums) {
            sum+=ele;
        }
        if(sum%2!=0) return false;//if array sum is odd, no two equal subsets can be created
        c=sum/2;
        int[][] dp=new int[nums.length][c+1];
        for(int i=0;i< dp.length;i++)
            for(int j=0;j<dp[0].length;j++) dp[i][j]=-1;
        
        return subsetMemo(0,nums,c,dp);
    }
}
//Tabulation
class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0,C=Integer.MIN_VALUE, n=nums.length;
        for(int ele:nums) sum+=ele;
        //if array sum is odd, no two equal subsets can be created
        if(sum%2!=0) return false;
        C=sum/2;

        int[][] dp=new int[n][C+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<C+1;j++){
                boolean ans = false;
                boolean skip = (i>0) ? (dp[i-1][j]==1) : (j==0);
                if(j-nums[i]<0) ans=skip;
                else{
                    boolean take = (i>0) ? (dp[i-1][j-nums[i]]==1) : (j==0);
                    ans=take||skip;
                }
                dp[i][j]= (ans) ? 1:0;
            }
        }
        return (dp[n-1][C]==1);
    }
}
