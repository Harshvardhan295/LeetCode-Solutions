//Recursive
class Solution {
    public int tribonacci(int n) {
        if(n==0) return 0;
        if(n==1 ||n==2) return 1;
        return tribonacci(n-1)+tribonacci(n-2)+tribonacci(n-3);
    }
}
//Memoization
class Solution {
    public int helper(int n,int[] dp){
        if(n==0) return 0;
        if(n==1 ||n==2) return 1;
        if(dp[n]!=0) return dp[n];
        return dp[n]=helper(n-1,dp)+helper(n-2,dp)+helper(n-3,dp);
    }
    public int tribonacci(int n) {
        int[] dp=new int[n+1];
        return helper(n,dp);
    }
}
//Tabulation
