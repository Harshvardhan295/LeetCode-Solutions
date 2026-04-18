class Solution {
    public int minFlips(int a, int b, int c) {
        int ans = 0;
        
        while (a != 0 || b != 0 || c != 0) {
            int x = a & 1;
            int y = b & 1;
            int z = c & 1;
            
            if (z == 0) {
                // both should be 0
                if (x == 1) ans++;
                if (y == 1) ans++;
            } else {
                // at least one should be 1
                if (x == 0 && y == 0) ans++;
            }
            
            a >>= 1;
            b >>= 1;
            c >>= 1;
        }
        
        return ans;
    }
}
