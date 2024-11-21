class Solution {
    public boolean searchMatrix(int[][] arr, int target) {
        int rows = arr.length;
        int cols = arr[0].length;
        
        int low = 0;
        int high = rows * cols - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midValue = arr[mid / cols][mid % cols];

            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}
