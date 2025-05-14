//approach 1
class Solution {
    
    public int findUnsortedSubarray(int[] nums) {
        int n=nums.length;
        int start=0,end=n-1;
        // Find the first index where order breaks
        while(start<n-1 && nums[start]<=nums[start+1]) start++;

        // If order does not break then array is already sorted
        if (start == n - 1) {
            return 0;
        }

        // Find the last index where order breaks
        while(end>0 && nums[end-1]<=nums[end]) end--;

        //find the max and min in this sub array
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        //now check if elements of nums before start are smaller than min and after end are greater than max
        while (start > 0 && nums[start - 1] > min) {
            start--;
        }

        while (end < n - 1 && nums[end + 1] < max) {
            end++;
        }

        return end-start+1;
    }
}
//approach 2
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int[] sortedNums = nums.clone();
        Arrays.sort(sortedNums);

        int start = n, end = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] != sortedNums[i]) {
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }

        return end - start >= 0 ? end - start + 1 : 0;
    }
}
