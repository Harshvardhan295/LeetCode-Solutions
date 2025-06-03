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
