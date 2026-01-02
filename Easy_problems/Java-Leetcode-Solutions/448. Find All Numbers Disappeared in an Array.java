class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans=new ArrayList<Integer>();
        int n=nums.length;
        for(int i=0; i<n; i++){
            //nums[i]== nums[nums[i]-1] -> means that number is in right position
            while(nums[i]>0 && nums[i]<=n && nums[nums[i]-1] != nums[i]){
                //if not in right place, then swap
                int temp = nums[i];
                nums[i] = nums[temp-1];
                nums[temp-1] = temp;
            }
        }
        for(int i=0;i<n;i++){
            if(nums[i]!=i+1) ans.add(i+1);
        }
        return ans;
    }
}
