//Binary Search
class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        
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
}
//Brute Force
class Solution {
    public int findPeakElement(int[] arr) {
        int n = arr.length;
        if (n == 1) return 0; //if length is 1
        if (arr[0] > arr[1]) return 0; // for 1st element
        if (arr[n - 1] > arr[n - 2]) return n - 1; // for last element

        for (int i = 1; i < n - 1; i++) {
            if (arr[i] > arr[i + 1] && arr[i] > arr[i - 1]) {
                return i;
            }
        }
        return 0; 
    }
}
