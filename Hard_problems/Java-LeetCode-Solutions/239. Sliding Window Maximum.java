//Brute Force
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] maxarr = new int[nums.length - k + 1];
        
        for (int i = 0; i <= nums.length - k; i++) {
            int max = Integer.MIN_VALUE;
            
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            
            maxarr[i] = max;
        }
        
        return maxarr;
    }
}
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] maxarr = new int[nums.length - k + 1];
        
        Deque<Integer> q = new LinkedList<>();//to store indices in decreasing order
        
        for (int i = 0; i < nums.length; i++) {
            // Remove elements that are out of the current window
            if (!q.isEmpty() && q.peekFirst() < i - k + 1) {
                q.pollFirst();
            }
            
            // Remove elements smaller than the current element from the deque
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.pollLast();
            }
            
            // Add current element's index to the deque
            q.offerLast(i);
            
            // If the window has reached size k, add the front of dequeue to array
            if (i >= k - 1) {
                maxarr[i - k + 1] = nums[q.peekFirst()];
            }
        }
        
        return maxarr;
    }
}
