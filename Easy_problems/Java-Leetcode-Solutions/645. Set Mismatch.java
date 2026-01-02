class Solution {
    public int[] findErrorNums(int[] nums) {
        HashSet<Integer> s=new HashSet<>();
        int[] ans=new int[2];
        for(int i=0;i<nums.length;i++){
            if(s.contains(nums[i])) ans[0]=nums[i];
            else s.add(nums[i]);
        }
        for(int i=0;i<nums.length;i++){
            if(!s.contains(i+1)) ans[1]=i+1;
        }
        return ans;
    }
}
