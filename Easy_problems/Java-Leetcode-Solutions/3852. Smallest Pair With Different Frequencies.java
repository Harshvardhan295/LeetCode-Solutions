class Solution {
    public int[] minDistinctFreqPair(int[] nums) {
        HashMap<Integer,Integer> mp=new HashMap<>();
        int n=nums.length;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
            min=Math.min(min,nums[i]);
        }
        int secmin=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(nums[i]!=min && mp.get(nums[i])!=mp.get(min) ) {
                secmin=Math.min(secmin,nums[i]);
            }
        }
        if(secmin==Integer.MAX_VALUE) return new int[]{-1,-1};
        return new int[]{min,secmin};
        
    }
}
