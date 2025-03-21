//Recursion
class Solution {
    public int amount(int[] nums,int i){
        if(i>=nums.length) return 0;
        int take= nums[i] + amount(nums,i+2);
        int skip= amount(nums,i+1);
        return Math.max(take,skip);
    }

    public int rob(int[] nums) {
        return amount(nums, 0);
    }
}
