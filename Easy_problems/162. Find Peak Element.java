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
