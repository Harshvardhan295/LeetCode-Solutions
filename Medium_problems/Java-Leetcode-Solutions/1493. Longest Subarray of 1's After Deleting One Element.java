//Sliding Window
class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int z=0;
        //if all 1's, then remove a single '1' 
        for(int ele: nums){
            if(ele==0)z++;
        }
        if(z==0) return n-1; 

        int i = 0, j = 0;
        int zeroes = 0, maxlen = 0;

 while(i<n && nums[i]==0) i++; //move i to 1st 1
        if(i==n) return 0;//all elements are '0'
        j=i;
        
        //Sliding Window
        while(j<n){
            if(nums[j]==1) j++;
            else{ //nums[j]==0
                if(zeroes==0){
                    j++;
                    zeroes++;
                }
                else{ //zeroes>0
                    int len=j-i-1;
                    maxlen=Math.max(maxlen,len);
                    j++;
                    while(i<n && nums[i]==1) i++; //move i to the next 0
                    i++; //move i to the next 1
                }
            }
        }
        
    if(zeroes==0) return j-i;//No zeroes inbetween subarray of ones
    int len=j-i-1;
    maxlen=Math.max(maxlen,len);
    return maxlen;
    }
}

