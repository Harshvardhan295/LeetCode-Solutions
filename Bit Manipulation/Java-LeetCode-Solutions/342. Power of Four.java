class Solution {
    public boolean isPowerOfFour(int n) {
    return n > 0 && (n & (n - 1)) == 0 && (n - 1) % 3 == 0;
}
}

//brute force (recursion)
class Solution {
    public boolean isPowerOfFour(int n) {
        if(n==1) return true;
        if(n<=0 || n%4!=0) return false;
        return isPowerOfFour(n/4);
    }
}

//O(1)
class Solution {
    public boolean isPerfectSquare(int n){
        int a=(int)(Math.sqrt(n));
        return (a*a==n);
    }
    public boolean isPowerOfFour(int n) {
        if(n<=0) return false;
        // n&(n-1) ==0 means it is of the power 2 
        return ((n& (n-1))==0) && isPerfectSquare(n);
    }
}
//O(1) with observation
class Solution { 
    public boolean isPowerOfFour(int n) {
        if(n<=0) return false;
        // n & (n-1) ==0 means it is of the power 2 
        //any power of 4 leaves remainder 1
        // when divided by 3
        return ((n& (n-1))==0) && n%3 ==1;
    }
}
