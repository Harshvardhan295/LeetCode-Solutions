class Solution {
    public int minimumOR(int[][] v) {
        int ans = (1 << 17) - 1;

        // Iterate through each bit from 16 down to 0
        for (int b = 16; b >= 0; b--) {
            // Try removing the b-th bit from the current answer
            int mask = ans & ~(1 << b);
            if (canMask(v, mask)) {
                ans = mask;
            }
        }
        return ans;
    }

    // Helper method to check if a specific mask is achievable
    private boolean canMask(int[][] v, int mask) {
        for (int[] row : v) {
            boolean ok = false;
            for (int x : row) {
                // Check if x contains all the bits set in the mask
                if ((x | mask) == mask) {
                    ok = true;
                    break;
                }
            }
            // If no element in a row satisfies the mask, this mask is invalid
            if (!ok) return false;
        }
        return true;
    }
}
