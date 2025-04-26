//Recursion
class Solution {
        public int helper(int[] nums1, int[] nums2, int i, int j) {
        if (i == nums1.length || j == nums2.length) return 0;
        
        if (nums1[i] == nums2[j]) return 1 + helper(nums1, nums2, i + 1, j + 1);
        else return Math.max(helper(nums1, nums2, i + 1, j), helper(nums1, nums2, i, j + 1));
    }
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        return helper(nums1, nums2, 0, 0);
    }
}
//Memoization
class Solution {
    //memoization
        public int helper(int[] nums1, int[] nums2, int i, int j,int[][] dp) {
        if (i == nums1.length || j == nums2.length) return 0;
        if(dp[i][j] !=-1) return dp[i][j];
        if (nums1[i] == nums2[j]) return dp[i][j]=1 + helper(nums1, nums2, i + 1, j + 1,dp);
        else return dp[i][j]=Math.max(helper(nums1, nums2, i + 1, j,dp), helper(nums1, nums2, i, j + 1,dp));
    }
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m=nums1.length,n=nums2.length;
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        return helper(nums1, nums2, 0, 0,dp);
    }
}
//Tabulation
class Solution {
    //Tabulation
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[][] dp = new int[m+1][n+1];
        for(int i=0; i<=m; i++) {
            dp[i][0] = 0;
        }
        for(int i=0; i<=n; i++) {
            dp[0][i] = 0;
        }
        
        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if(nums1[i-1] == nums2[j-1]) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}
