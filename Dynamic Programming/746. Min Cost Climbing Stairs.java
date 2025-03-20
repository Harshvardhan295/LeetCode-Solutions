//Recusive
class Solution {
     public int minCost(int[] cost,int idx) {
        if(idx==0 || idx==1) return cost[idx];
        return cost[idx]+Math.min(minCost(cost,idx-1),minCost(cost,idx-2));
    }
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        return Math.min(minCost(cost,n-1),minCost( cost,n-2));
    }
}
