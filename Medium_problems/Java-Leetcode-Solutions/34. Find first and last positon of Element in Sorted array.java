class Solution {
    public int[] searchRange(int[] arr, int target) {
        int n = arr.length;
        int[] ans = {-1, -1};

        // First position
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2; // To avoid overflow

            if (arr[mid] == target) {
                // Move towards the left to find the first position
                ans[0] = mid;
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // Last position
        low = 0;
        high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2; // To avoid overflow

            if (arr[mid] == target) {
                // Move towards the right to find the last position
                ans[1] = mid;
                low = mid + 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
}
