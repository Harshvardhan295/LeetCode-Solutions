//similar to memoization using variables
class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int first = 1, second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
}

//recursion
class Solution {
    public int climbStairs(int n) {
        if(n<=2) return n;
        else return climbStairs(n-1)+climbStairs(n-2);
    }
}
//memoization
class Solution {
    public int ans(int[] dp, int n) {
        if (n <= 2)
            return n;
        if(dp[n]!=-1) return dp[n];
            return dp[n]=ans(dp,n - 1) + ans(dp,n - 2);
    }

    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return ans(dp,n);
    }
}

//tabulation
class Solution {

    public int climbStairs(int n) {
        if (n <= 2)
            return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
