class Solution {
    public int dominantIndices(int[] nums) {
        int[] suffix= new int[nums.length];
        suffix[nums.length-1]=nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            suffix[i]=suffix[i+1]+nums[i];
        }
        int ans=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>suffix[i+1]/(nums.length-(i+1))) ans++;
        }
        return ans;
    }
}
