//Binary Search
class Solution {
    public int maximumCandies(int[] candies, long k) {
        int low = 1, high = 0;
        for (int ele : candies) {
            high = Math.max(high, ele);
        }

        int result = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long count = 0;
            for (int ele : candies) {
                count += ele / mid; // Number of children that can get `mid` candies from this pile
            }

            if (count >= k) { // We can distribute `mid` candies per child
                result = mid;
                low = mid + 1; 
            } else {
                high = mid - 1; 
            }
        }
        return result;
    }
}
