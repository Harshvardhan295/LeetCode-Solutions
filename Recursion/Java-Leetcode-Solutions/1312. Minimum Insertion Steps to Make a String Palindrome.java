

//Recursion
class Solution {
    //recursion 
    public int mInsertion(String s, int i, int j){
        if(j<=i) return 0;
        if(s.charAt(i)!=s.charAt(j)) {
            int moveLeft=mInsertion(s,i,j-1);
            int moveRight=mInsertion(s,i+1,j);
            return 1 + Math.min(moveLeft,moveRight);
        }
        else return mInsertion(s,i+1,j-1);  
    }   
    public int minInsertions(String s) {
        int n=s.length();
        return mInsertion(s,0,n-1);
    }
}

//Memoization
class Solution {
    //memoization
    public int mInsertion(String s, int i, int j,int[][] dp){
        if(j<=i) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)!=s.charAt(j)) {
            int moveLeft=mInsertion(s,i,j-1,dp);
            int moveRight=mInsertion(s,i+1,j,dp);
            return dp[i][j]=1 + Math.min(moveLeft,moveRight);
        }
        else return dp[i][j] =mInsertion(s,i+1,j-1,dp);  
    }   
    public int minInsertions(String s) {
        int n=s.length();
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++) dp[i][j]=-1; 
        return mInsertion(s,0,n-1,dp);
    }
}

//Tabulation
class Solution {
    //Tabulation
    public int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n-1; i >= 0; i--) {
            dp[i][i] = 0; // Base case
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) != s.charAt(j)) {
                    int moveLeft = dp[i][j-1];
                    int moveRight = dp[i+1][j];
                    dp[i][j] = 1 + Math.min(moveLeft, moveRight);
                } else
                    dp[i][j] = dp[i+1][j-1];
            }
        }
        return dp[0][n - 1];
    }
}

//Memoization with LPS
class Solution {
    //Memoization method with LPS
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
    public String reverseString(String s) {
        StringBuilder reversed = new StringBuilder(s);
        return reversed.reverse().toString();
    }
    public int longestPalindromeSubseq(String s) {
        return longestCommonSubsequence(s,reverseString(s));
    }
    public int minInsertions(String s) {
        return s.length()-longestPalindromeSubseq(s);
    }
}


