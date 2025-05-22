//Recursion 
class Solution {
    public int longestCommonSubsequence(String a, String b) {
        int m=a.length(),n=b.length();
        if(m==0||n==0) return 0;
        String a2=a.substring(0,m-1);//does not includes m-1
        String b2=b.substring(0,n-1);//does not includes n-1
        if(a.charAt(m-1)==b.charAt(n-1)){
            return 1+longestCommonSubsequence(a2,b2);
        }
        else{
            int atake=longestCommonSubsequence(a2,b);
            int btake=longestCommonSubsequence(a,b2);
            return Math.max(atake,btake);
        }
    }
}
//Memoization using stringbuilder
class Solution {
    //Memoization
    public int lcs(int i, int j,StringBuilder a, StringBuilder b,int[][] dp){
        if(i<0||j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(a.charAt(i)==b.charAt(j)){
            return dp[i][j]= 1+lcs(i-1,j-1,a,b,dp);
        }
        else{
            int atake=lcs(i-1,j,a,b,dp);
            int btake=lcs(i,j-1,a,b,dp);
            return dp[i][j]=Math.max(atake,btake);
        }
    }
    public int longestCommonSubsequence(String text1, String text2) {
        //StringBuilder is mutable, so it's slightly more memory-efficient if strings are modified often. However, in this case, no modification happens, so both perform the same.
        StringBuilder a = new StringBuilder(text1);
        StringBuilder b = new StringBuilder(text2);
        int m=a.length(),n=b.length();
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++) dp[i][j]=-1;
        return lcs(m-1,n-1,a,b,dp);
    }
}
