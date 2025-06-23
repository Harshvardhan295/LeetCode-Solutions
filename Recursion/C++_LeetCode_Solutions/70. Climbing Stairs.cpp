//Recursion
class Solution {
public:
    int helper(int n,vector<int>& dp){
        if(n<=1) return 1;
        if(dp[n]!=-1) return dp[n];
        int take=1+helper(n-1,dp)+helper(n-2,dp);
        int skip=helper(n-1,dp)+helper(n-2,dp);
        return dp[n]=min(take,skip);
    }
    int climbStairs(int n) {
        vector<int> dp(n+1,-1);
        return helper(n,dp);
    }
};
//Memoization
class Solution {
public:
    int helper(int n,vector<int>& dp){
        if(n<=1) return 1;
        if(dp[n]!=-1) return dp[n];
        int take=1+helper(n-1,dp)+helper(n-2,dp);
        int skip=helper(n-1,dp)+helper(n-2,dp);
        return dp[n]=min(take,skip);
    }
    int climbStairs(int n) {
        vector<int> dp(n+1,-1);
        return helper(n,dp);
    }
};
