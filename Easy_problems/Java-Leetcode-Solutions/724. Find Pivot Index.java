class Solution {
    public int pivotIndex(int[] nums) {
        for(int i=1;i<nums.length;i++){
            nums[i]+=nums[i-1];
        }
        for(int i=1;i<nums.length;i++){
            int leftsum=nums[i-1]-nums[0];
            int rightsum=nums[nums.length-1]-nums[i];
            if(leftsum==rightsum) return i;
        }
        return -1;
    }
}
