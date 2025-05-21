//Recursion
class Solution {
    public long coinCount(int i, int[] coins, int amount){
        if(i==coins.length) {
            if(amount==0) return 0;//means no more coins needed
            else return Integer.MAX_VALUE; //not a valid answer
        }
        long skip=coinCount(i+1,coins,amount);
        if(amount-coins[i]<0) return skip;
        long take=1+ coinCount(i,coins,amount-coins[i]);
        return Math.min(skip,take);

    }
    public int coinChange(int[] coins, int amount) {
        int ans=(int)coinCount(0,coins,amount);
        if(ans==Integer.MAX_VALUE) return -1;
        return ans;
    }
}
//Memoization
class Solution {
    public long coinCount(int i, int[] coins, int amount,long[][] dp){
        if(i==coins.length) {
            if(amount==0) return 0;//means no more coins needed
            else return Integer.MAX_VALUE; //not a valid answer
        }
        if(dp[i][amount]!=-1) return dp[i][amount];
        long skip=coinCount(i+1,coins,amount,dp);
        if(amount-coins[i]<0) return dp[i][amount]=skip;
        long take=1+ coinCount(i,coins,amount-coins[i],dp);
        return dp[i][amount]=Math.min(skip,take);

    }
    public int coinChange(int[] coins, int amount) {
        long[][] dp=new long[coins.length][amount+1];
        for (int i = 0; i < dp.length; i++) {
           for (int j = 0; j < dp[0].length; j++) {
               dp[i][j] = -1;
           }
       }
        int ans= (int) coinCount(0,coins,amount,dp);
        if(ans==Integer.MAX_VALUE) return -1;
        return ans;
    }
}
//Space Optimization
class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        long[][] dp = new long[2][amount + 1];//i-1:0 & i=1 -> dp
        //Tabulation with space optimization
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < amount+1; j++) {
                long skip=(i>0) ? dp[0][j] : ((j==0) ? 0: Integer.MAX_VALUE);
                if (j - coins[i] < 0) dp[1][j] = skip;
                else{
                    long take = 1 + dp[1][j - coins[i]];
                    dp[1][j] = Math.min(skip, take);
                }
            }
            //copy paste first row to 0th row
            for(int j=0;j<amount+1;j++){
                dp[0][j]=dp[1][j];
            }
        }
        int ans = (int) dp[1][amount];
        if (ans == Integer.MAX_VALUE) return -1;
        return ans;
    }
}
