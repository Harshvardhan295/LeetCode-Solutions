//memoization with LCS
class Solution {
    //Memoization method with LCS
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
        StringBuilder a = new StringBuilder(text1);
        StringBuilder b = new StringBuilder(text2);
        int m=a.length(),n=b.length();
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++) dp[i][j]=-1;
        return lcs(m-1,n-1,a,b,dp);
    }
    public int longestPalindromeSubseq(String s) {
        return longestCommonSubsequence(s,reverseString(s));
    }
    public String reverseString(String s) {
        StringBuilder reversed = new StringBuilder(s);
        return reversed.reverse().toString();
    }
}
//recursion
class Solution {
    //recursion
    public int lps(String s, int i, int j){
        if(j<i) return 0;
        if(i==j) return 1;
        if(s.charAt(i)==s.charAt(j))  return 2+ lps(s,i+1,j-1);
        else{
            int moveLeft=lps(s,i,j-1);
            int moveRight=lps(s,i+1,j);
            int moveCenter=lps(s,i+1,j-1);
            return Math.max(moveLeft,Math.max(moveRight,moveCenter));
        }
    }
    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        return lps(s,0,n-1);
    }
}
//memoization
class Solution {
    //memoization
    public int lps(String s, int i, int j,int[][] dp){
        if(j<i) return 0;
        if(i==j) return 1;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==s.charAt(j)) return dp[i][j]= 2+ lps(s,i+1,j-1,dp);
        else{
            int moveLeft=lps(s,i,j-1,dp);
            int moveRight=lps(s,i+1,j,dp);
            int moveCenter=lps(s,i+1,j-1,dp);
            return dp[i][j]= Math.max(moveLeft,Math.max(moveRight,moveCenter));
        }
    }
    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++) dp[i][j]=-1;        
        return lps(s,0,n-1,dp);
    }
}
//tabulation
class Solution {
    //Tabulation
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        //Fill diagonally - bottom-up, right-to-left
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1; // Base case
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    int moveLeft = dp[i][j - 1];
                    int moveRight = dp[i + 1][j];
                    int moveCenter = dp[i + 1][j - 1];
                    dp[i][j] = Math.max(moveLeft, Math.max(moveRight, moveCenter));
                }
            }
        }
        return dp[0][n - 1];
    }
}
