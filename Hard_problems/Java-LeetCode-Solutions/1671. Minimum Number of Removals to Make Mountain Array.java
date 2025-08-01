class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] dp1 = new int[n];
        //left to right LIS
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i - 1; j++) {
                if (nums[j] < nums[i])
                    dp1[i] = Math.max(dp1[i], dp1[j]);
            }
            dp1[i] += 1;
        }
        
        //right to left LIS
        int[] dp2 = new int[n];
        for (int i = n-1; i >=0; i--) {
            for (int j = i+1; j < n; j++) {
                if (nums[j] < nums[i])
                    dp2[i] = Math.max(dp2[i], dp2[j]);
            }
            dp2[i] += 1;
        }
        
        int maxLen=0;//max length of mountain array
        for(int i=0;i<n;i++){
            if(dp1[i]>1 && dp2[i]>1){
                int len=dp1[i]+dp2[i]-1;
                maxLen=Math.max(maxLen,len);
            }
        }
        if(maxLen<3) return 0;//not forming any mountain array
        return n-maxLen;//minimum removal of elements to make mountain array
    }
}
