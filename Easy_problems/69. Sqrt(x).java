class Solution {
    public int mySqrt(int x) {
        int low=0;
        int high = x;
           if(x<=1) return x;
            while (low <= high) {
                int mid = low + (high - low) / 2; // To avoid overflow

                if (mid == x/mid) {
                   return mid;
                } else if (mid < x/mid) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return high;//It is concept to understand why we have returned high
    }
}
// Or we can also use long instead of int as long as big value than int
