class Solution {
    public int findFinalValue(int[] nums, int o) {
        int ans=0;
        HashSet<Integer> mp=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            mp.add(nums[i]);
        }
        if(!mp.contains(o)) return o;
        ans=o;
        for(int i=1;i<mp.size();i++){
            if(mp.contains(ans *2)){
                ans*=2;
            }
        }
        return ans*2;
    }
}
