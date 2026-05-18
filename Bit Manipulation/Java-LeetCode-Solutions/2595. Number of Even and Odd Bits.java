class Solution {
    public int[] evenOddBit(int n) {
        int even = 0, odd = 0;
        int index = 0;

        while (n > 0) {
            //check if rightmost bit is 1
            // if yes, then check it that idx is even or not
            if ((n & 1) == 1) {
                if (index % 2 == 0) even++; 
                else odd++;
            }
            n = n >> 1; // right shift
            index++;
        }

        return new int[]{even, odd};
    }
}
