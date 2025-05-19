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
