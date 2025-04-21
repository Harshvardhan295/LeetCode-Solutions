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
//
