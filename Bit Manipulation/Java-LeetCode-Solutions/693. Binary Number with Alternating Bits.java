class Solution {
    public boolean hasAlternatingBits(int n) {
        int a=n&1;
        n>>=1;
        while(n!=0){
            if(a == (n&1)) return false;
            n>>=1;
            a= a^1;
        }
        return true;
    }
}
