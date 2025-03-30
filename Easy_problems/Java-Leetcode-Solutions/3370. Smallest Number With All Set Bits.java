//-------M1-------
  class Solution {
    public int smallestNumber(int n) {
        int res = 1;
        while (res < n)
            res = res * 2 + 1;
        return res;
    }
}
//-------M2--------
class Solution {
    public int smallestNumber(int n) {
        int power=1;
        for(int i=0;i<n;i++){
            power*=2;
            if(power>n) return power-1;
        }
        return power-1;
    }
}
