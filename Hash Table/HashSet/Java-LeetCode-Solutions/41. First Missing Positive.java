class Solution {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> set =new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        for(int i=0;i<set.size();i++){
            if(!set.contains(i+1)) return i+1;
        }
        int m=Integer.MIN_VALUE;
        for(int a: nums){
            m=Math.max(m,a);
        }
        return m+1;
    }
}
