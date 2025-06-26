//Recursion
class Solution {
public:
    int climbStairs(int n) {
        if(n<=1) return 1;
        int take=1+climbStairs(n-1)+climbStairs(n-2);
        int skip=climbStairs(n-1)+climbStairs(n-2);
        return min(take,skip);
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
//Tabulation
class Solution {
public:
    int climbStairs(int n) {
        if (n <= 2) return n;
        vector<int> dp(n+1,-1);
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
};
