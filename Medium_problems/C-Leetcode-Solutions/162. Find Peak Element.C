//Code with edge conditions
int findPeakElement(int* arr, int n) {
    if (n == 1) return 0;  
    if (arr[0] > arr[1]) return 0;  
    if (arr[n - 1] > arr[n - 2]) return n - 1;  

    int low = 1;
    int high = n - 2;

    while (low <= high) {
        int mid = low + (high - low) / 2;

        if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
            return mid; 
        } else if (arr[mid] < arr[mid - 1]) {
            high = mid - 1;  // Move to the left half
        } else {
            low = mid + 1;  // Move to the right half
        }
    }

    return -1;  // This should not happen for valid input
}
//optimised code
int findPeakElement(int* nums, int n) {
     int low = 0;
        int high = n - 1;
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[mid + 1]) {//if mid is greater than next element then peak element should be in the left half
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
}
