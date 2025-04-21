//recursion
class Solution {
    public boolean isPerfect(int n) {
    int sqrt = (int) Math.sqrt(n);
    return sqrt * sqrt == n;
}

    public int numSquares(int n) {
        if(isPerfect(n)) return 1;
        int min=Integer.MAX_VALUE;
        for(int i=1;i<=n/2;i++){
            int count=numSquares(i)+numSquares(n-i);
            min=Math.min(min,count);
        }
        return min;
    }
}
//memoization
class Solution {
    public boolean isPerfect(int n) {
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }

    public int ans(int n, int[] dp) {
        if (isPerfect(n)) return 1;
        int min = Integer.MAX_VALUE;
        if (dp[n] != -1) return dp[n];
        for (int i = 1; i <= n / 2; i++) {
            int count = ans(i, dp) + ans(n - i, dp);
            min = Math.min(min, count);
        }
        return dp[n]=min;
    }

    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return ans(n,dp);
    }
}
//Tabulation-O(n^2)
class Solution {
    public boolean isPerfect(int n) {
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }

    //tabulation - O(n^2)
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (isPerfect(i)) dp[i]=1;
            else {
                int min = Integer.MAX_VALUE;
                for (int j = 1; j <= i/2; j++) {
                    int count = dp[j] + dp[i - j];
                    min = Math.min(min, count);
                }
                dp[i] = min;
            }
        }
        return dp[n];
    }
}
//
