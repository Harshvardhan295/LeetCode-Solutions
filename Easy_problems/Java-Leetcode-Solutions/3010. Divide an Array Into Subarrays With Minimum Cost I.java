class Solution {
    public int minimumCost(int[] nums) {
        int min=Integer.MAX_VALUE,i2=-1;
        int min2=Integer.MAX_VALUE;
        int n=nums.length,i=1;
        while(i<n){
            if(nums[i]<min){
                min=nums[i];
                i2=i;
            }
            i++;
        }
        i=1;
        while(i<n){
            if(i!=i2) min2=Math.min(min2,nums[i]);
            i++;
        }
        return nums[0]+min+min2;
    }
}
