class Solution {
    public int hammingWeight(int n) {
        //Brute Force
        int cnt=0;
        for(int i=0;i<32;i++){
            int mask= 1<<i;
            if((n & mask)!=0) cnt++;
        }
        return cnt;
    }
}
