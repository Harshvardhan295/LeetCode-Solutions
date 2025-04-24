//Recursion
class Solution {
    public int fib(int n) {
        if(n<=1) return n;
        else return fib(n-1)+fib(n-2);
    }
}
//Memoization
class Solution {
    public int helper(int n, int[] dp){
        if(n<=1) return n;
        if(dp[n]!=0) return dp[n];
        int ans= fib(n-1)+fib(n-2);
        dp[n]=ans;
        return ans;
    }
    public int fib(int n) {
        int[] dp=new int[n+1];
        return helper(n,dp);
    }
}
//Tabulation
class Solution {
    public int fib(int n) {
        if (n <= 1) return n;
        int[] dp=new int[n+1];
        dp[0]=0; dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
//Space Optimisation
class Solution {
    public int fib(int n) {
        if (n <= 1) return n;
        int[] dp=new int[3];
        dp[0]=0; dp[1]=1;
        //Space Optimization
        for(int i=2;i<=n;i++){
            dp[2]=dp[1]+dp[0];
            dp[0]=dp[1];
            dp[1]=dp[2];
        }
        return dp[2];
    }
}
