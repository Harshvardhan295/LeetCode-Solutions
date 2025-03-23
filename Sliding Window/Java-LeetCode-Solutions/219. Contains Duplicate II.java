class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (i > k)  set.remove(nums[i - k - 1]);
            if (set.contains(nums[i])) return true; // Duplicate found within the window of size k
            set.add(nums[i]);
        }
        return false; // No duplicate found within the given distance k
    }
}
