class Solution {
    public boolean consecutiveSetBits(int n) {
        while (n > 0 && (n & 1) == 0) {
            n = n >> 1;
        }
        int pairs = 0;
        while (n > 0) {
            if ((n & 1) == 1 && ((n >> 1) & 1) == 1) {
                pairs++;
            }
            n = n >> 1;
        }

        return pairs == 1;
    }
}
