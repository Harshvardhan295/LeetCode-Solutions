int search(int* arr, int numsSize, int target) {
     int low=0;
            int high = numsSize-1;
            while (low <= high) {
                int mid = low + (high - low) / 2; // To avoid overflow

                if (arr[mid] == target) {
                    return mid;
                } else if (arr[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
                return -1;
}
