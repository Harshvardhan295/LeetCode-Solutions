class Solution {
    public long[] findPrefixScore(int[] nums) {
        long[] convert = new long[nums.length];
        long max = 0, sum = 0;

        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);  
            sum += nums[i] + max;          
            convert[i] = sum;              
        }
        return convert;
    }
}

