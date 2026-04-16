public class Solution {
    public int reverseBits(int n) {
        int res = 0;
        // right shift res and left n for reverse
        for (int i = 0; i < 32; i++) {
            int a = n & 1; // get the last bit of n
            res = res << 1; // right shift res to add a
            res |= a;
            n >>= 1; //left shift n for reversing bits
        }
        return res;
    }
}
