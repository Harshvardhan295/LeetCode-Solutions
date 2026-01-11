class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int i=0,count=0,maxCnt=0;
        while(i<nums.length){
            if(nums[i]==1) {
                count++;
                maxCnt=Math.max(count,maxCnt);
            }else count=0;

            i++;
        }
        return maxCnt;
    }
}
