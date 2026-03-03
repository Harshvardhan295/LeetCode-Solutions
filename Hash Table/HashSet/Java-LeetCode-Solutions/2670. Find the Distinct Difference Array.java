class Solution {
    public int[] distinctDifferenceArray(int[] nums) {
        int n = nums.length;
        int prefix[] = new int[n];
        int suffix[] = new int[n];
        Set<Integer> prefixSet = new HashSet<>();
        Set<Integer> suffixSet = new HashSet<>();

        prefix[0] = 1;
        prefixSet.add(nums[0]);
        
        for(int i = 1;i<n;i++){
            prefixSet.add(nums[i]);
            prefix[i] = prefixSet.size();
        }
        for(int i = n-1;i>=0;i--){
            suffix[i] = suffixSet.size();
            suffixSet.add(nums[i]);
        }

        int ans[] = new int[n];
        for(int i = 0;i<n;i++){
            ans[i] = prefix[i] - suffix[i];
        }
        return ans;

    }
}
