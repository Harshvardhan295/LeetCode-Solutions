class Solution {
    public int finalElement(int[] nums) {
        int min=Integer.MAX_VALUE;
        if(nums.length==1) return nums[0];
        else if(nums.length==2) {
            if(nums[0]>nums[1]) return nums[0];
            else return nums[1];
        }
        else{
            min=Math.max(nums[0],nums[nums.length-1]); 
            return min;
        } 
    }
}
