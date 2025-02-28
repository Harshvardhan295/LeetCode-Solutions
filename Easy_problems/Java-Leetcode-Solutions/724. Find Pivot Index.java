class Solution {
    public static boolean leftprefixSum(int[] nums){
        for(int i=2;i<nums.length;i++){
            nums[i]+=nums[i-1];
        }
        if(nums[nums.length-1]==0) return true;
        return false;
    }
    public int pivotIndex(int[] nums) {
        int idx=0;
        if(idx==0) {
            if(leftprefixSum(nums)) return idx;
        }
        for(int i=1;i<nums.length-1;i++){
            int leftsum=nums[i-1]-nums[0];
            int rightsum=nums[nums.length-1]-nums[i];
            if(leftsum==rightsum) return i;
        }
        return -1;
    }
}
