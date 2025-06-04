//Recursion
class Solution {
    public static int checkSubsequence(String s, String t,int i, int j,int[][] dp){
        if(i>=s.length())   return 1;
        if(j>=t.length()) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==t.charAt(j)) return dp[i][j]=checkSubsequence(s,t,i+1,j+1,dp);
        else{
            return dp[i][j]=checkSubsequence(s,t,i,j+1,dp);
        }
    }
    public boolean isSubsequence(String s, String t) {
        int[][] dp=new int[s.length()][t.length()];
        for(int i=0;i<s.length();i++){
            for(int j=0;j<t.length();j++){
                dp[i][j]=-1;
            }
        }
        int ans=checkSubsequence(s,t,0,0,dp);
        return (ans==1);
    }
}
//Memoization
class Solution {
    public static int checkSubsequence(String s, String t,int i, int j,int[][] dp){
        if(i>=s.length())   return 1;
        if(j>=t.length()) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==t.charAt(j)) return dp[i][j]=checkSubsequence(s,t,i+1,j+1,dp);
        else{
            return dp[i][j]=checkSubsequence(s,t,i,j+1,dp);
        }
    }
    public boolean isSubsequence(String s, String t) {
        int[][] dp=new int[s.length()][t.length()];
        for(int i=0;i<s.length();i++){
            for(int j=0;j<t.length();j++){
                dp[i][j]=-1;
            }
        }
        int ans=checkSubsequence(s,t,0,0,dp);
        return (ans==1);
    }
}
//tabulation
class Solution {
    public boolean isSubsequence(String s, String t) {
        int m = s.length();
        int n = t.length();

        int[][] dp = new int[m + 1][n + 1];

        //filling table bottom-right to top-left
        for (int i = m - 1; i >= 0; i--) {
        for (int j = n - 1; j >= 0; j--) {
            if (s.charAt(i) == t.charAt(j)) {
                dp[i][j] = 1 + dp[i + 1][j + 1];
            } else {
                dp[i][j] = dp[i][j + 1];
            }
        }
    }

        return dp[0][0] == m;
    }
}
