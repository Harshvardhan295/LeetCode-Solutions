//Brute Force
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length, minLen = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(nums[i]==target) return 1;
        }
        for (int i = 0; i < n; i++) {
            int sum = 0, j = i;
            while (j<n && sum < target) {
                sum += nums[j++];
            }
            j--;
            int len = j - i + 1;
            if(sum>=target) minLen = Math.min(minLen, len);
        }
        if (minLen == Integer.MAX_VALUE)
            return 0;
        return minLen;
    }
}

// Sliding Window
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length, i = 0, j = 0;
        int minlen = Integer.MAX_VALUE, sum = 0;
        while (j < n && sum < target) { // first window
            sum += nums[j++];
        }
        j--;

        // Sliding Window
        while (i < n && j < n) {
            int len = j - i + 1;
            if (sum >= target){
                minlen = Math.min(minlen, len);
            } 
            sum -= nums[i];
            i++; 
            j++;
            while (j < n && sum < target) {
                sum += nums[j++];
            }
            j--;
        }
        if (minlen == Integer.MAX_VALUE)
            return 0;
        return minlen;
    }
}
