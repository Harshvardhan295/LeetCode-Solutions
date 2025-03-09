class Solution {
    public boolean find132pattern(int[] nums) {
        if(nums.length<3){
            return false;
        }
        int prevMin=Integer.MIN_VALUE;
        int peak=nums.length;
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]<prevMin) return true;
            while(peak<nums.length && nums[i] > nums[peak]){
                prevMin=nums[peak++];
            }
            peak--;
        nums[peak]=nums[i];
        }
        return false;
    }
}
