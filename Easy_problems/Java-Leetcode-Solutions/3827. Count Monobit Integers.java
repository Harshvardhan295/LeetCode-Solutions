class Solution {
    public int countMonobit(int n) {
        if (n == 0)
            return 1;
        int cnt = 1;// including n==0
        int val = 1; 
        // 1 , 3, 7, 15 are Monobit Integers so start with 1
        // then perform left shift(doubling) with Bitwise OR
        while (val <= n) {
            val = val << 1 | 1; 
            //val=val*2+1; 
            cnt++;
        }
        return cnt;
    }
}
