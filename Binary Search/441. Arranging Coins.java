class Solution {
    public int arrangeCoins(int n) {
        int low = 1;
        int high = n; 
        while (low <= high) {
            int mid = low + (high - low) / 2; 
            long sum =(long)  mid * (mid + 1) / 2; //Maths logic: sum of n natural numbers

            if (sum == n) {
                return mid; // Exact number of rows
            } else if (sum < n) {
                low = mid + 1; 
            } else {
                high = mid - 1; 
            }
        }
        return high; // The largest number of complete rows
    }
}
