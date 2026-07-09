class Solution {
    long base = 100007;
    long mod = 1000000007;

    public boolean isPossible(int[] nums, int k) {
        if (k == 0) return false;
        int n = nums.length;
        HashMap<Long, Integer> mp = new HashMap<>();

        long hash = 0, power = 1;
        
        // Calculate base^(k-1) % mod and initial window hash
        for (int i = 0; i < k; i++) {
            hash = (hash * base + nums[i]) % mod;
            if (i < k - 1) {
                power = (power * base) % mod;
            }
        }
        mp.put(hash, 1);

        // Sliding window from k to n
        for (int i = k; i < n; i++) {
            // Safely remove the out-of-window element (added explicit tracking variables)
            long removeTerm = (nums[i - k] * power) % mod;
            hash = (hash - removeTerm + mod) % mod;
            
            // Add the incoming element
            hash = (hash * base + nums[i]) % mod;

            mp.put(hash, mp.getOrDefault(hash, 0) + 1);
        }

        // Check if any subarray hash appeared exactly once
        for (long ele : mp.keySet()) {
            if (mp.get(ele) == 1) return true;
        }
        return false;
    }

    public int smallestUniqueSubarray(int[] nums) {
        // Change starting point from 0 to 1
        int l = 1, r = nums.length;
        int ans = 0;
        
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (isPossible(nums, mid)) {
                ans = mid;
                r = mid - 1; // Try to find a smaller unique subarray
            } else {
                l = mid + 1; // Increase window size
            }
        }
        return ans;
    }
}
