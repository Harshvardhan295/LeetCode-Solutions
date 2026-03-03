class Solution {
    int ans=0;
    public int helper(int n){
        if(n==1) return 0;
        int a=n/2;
        int b=n-a;
        ans+=a*b;
        return helper(a)+helper(b);
    }
    public int minCost(int n) {
        helper(n);
        return ans;        
    }
}
