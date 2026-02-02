class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {        
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = nums.clone();
        
        Arrays.sort(ans);
        for (int i = 0; i < nums.length; i++) map.putIfAbsent(ans[i], i);
        for (int i = 0; i < nums.length; i++) ans[i] = map.get(nums[i]);
        return ans;
    }
}
