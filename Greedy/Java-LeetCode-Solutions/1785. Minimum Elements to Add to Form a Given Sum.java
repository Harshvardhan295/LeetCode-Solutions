class Solution {
    public int minElements(int[] nums, int limit, int goal) {
        int n = nums.length;
        long sum = 0;
        long diff = 0;
        for(int i=0;i<n;i++){
            sum += nums[i];
        }
        diff = Math.abs(goal-sum);
        return (int) ((diff+limit-1)/limit);
    }
}
