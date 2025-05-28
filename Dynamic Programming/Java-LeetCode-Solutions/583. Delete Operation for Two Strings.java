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
    public int minDistance(String a, String b) {
        int common=2*longestCommonSubsequence(a,b);
        return (a.length()+b.length()) -common;
    }
}
//Memoization
class Solution {
    //Memoization
    public int lcs(int i, int j,String a, String b,int[][] dp){
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
    public int minDistance(String a, String b) {
        int m=a.length(),n=b.length();
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++) dp[i][j]=-1;
        int common=2*lcs(m-1,n-1,a,b,dp);
        return (a.length()+b.length()) - common;
    }
}
