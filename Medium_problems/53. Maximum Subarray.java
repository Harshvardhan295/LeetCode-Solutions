//-------------------Optimised code----------------
class Solution {
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        int sum=0;
        int maxsum=nums[0];
        for(int i=0;i<n;i++){
            sum+=nums[i];
            if(sum>maxsum){
                maxsum=sum;
            }
            if(sum<0){
                sum=0;
            }
        }
        return maxsum;
    }
}
//-------------------Brute Force----------------
class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int maxsum = Integer.MIN_VALUE; 
        
        for (int i = 0; i < n; i++) {
            int sum = 0; 
            
            for (int j = i; j < n; j++) {
                sum += nums[j]; 
                if (sum > maxsum) {
                    maxsum = sum;
                }
            }
        }
        
        return maxsum;
    }
}
