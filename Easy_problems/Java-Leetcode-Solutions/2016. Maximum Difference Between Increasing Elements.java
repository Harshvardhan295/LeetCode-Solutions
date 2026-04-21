//Brute force
class Solution {
    public int maximumDifference(int[] nums) {
        int n=nums.length;
        int ans=-1;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(nums[j]>nums[i]){
                    ans=Math.max(ans,nums[j]-nums[i]);
                }
            }
        }
        return ans;
    }
}
//optimal solution
class Solution {
    public int maximumDifference(int[] nums) {
        int min=nums[0];
        int diff=-1;
        for(int i=1;i<nums.length;i++){
            if(min<nums[i]){
                diff=Math.max(nums[i]-min,diff);
            }
            else{
                min=nums[i];
            }
        }
        return diff;
    }
}
