class Solution {
    public int centeredSubarrays(int[] nums) {
        int ans=0;
        for(int i=0;i<nums.length;i++){
            HashSet<Integer> set=new HashSet<>();
            set.add(nums[i]);
            int sum=nums[i];
            ans++;
            for(int j=i+1;j<nums.length;j++){
                set.add(nums[j]);
                sum+=nums[j];
                if(set.contains(sum)) ans++;
            }
        }
        return ans;
    }
}
