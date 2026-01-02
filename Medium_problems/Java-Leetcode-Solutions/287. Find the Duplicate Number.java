class Solution {
    public int findDuplicate(int[] nums) {
        HashSet<Integer> s=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(s.contains(nums[i])) return nums[i];
            else s.add(nums[i]);
        }
        return -1;
    }
}
