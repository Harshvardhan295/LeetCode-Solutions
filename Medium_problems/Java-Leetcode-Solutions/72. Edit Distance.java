//Recursion
class Solution {
    public int minSteps(int i,int j, StringBuilder a, StringBuilder b){
        if(i==-1) return j+1;
        if(j==-1) return i+1;
        if(a.charAt(i)==b.charAt(j)){
            return minSteps(i-1,j-1,a,b);
        }
        else{
            int del=minSteps(i-1,j,a,b);
            int ins=minSteps(i,j-1,a,b);
            int rep=minSteps(i-1,j-1,a,b);
            return 1+Math.min(del,Math.min(ins,rep));
        }
    }
    public int minDistance(String word1, String word2) {
        StringBuilder a=new StringBuilder(word1);
        StringBuilder b=new StringBuilder(word2);
        int m=a.length(),n=b.length();
        return minSteps(m-1,n-1,a,b);
    }
}
//Memoization
class Solution {
    public int minSteps(int i,int j, StringBuilder a, StringBuilder b,int[][] dp){
        if(i==-1) return j+1;
        if(j==-1) return i+1;
        if(dp[i][j]!=-1) return dp[i][j];
        if(a.charAt(i)==b.charAt(j)){
            return dp[i][j]=minSteps(i-1,j-1,a,b,dp);
        }
        else{
            int del=minSteps(i-1,j,a,b,dp);
            int ins=minSteps(i,j-1,a,b,dp);
            int rep=minSteps(i-1,j-1,a,b,dp);
            return dp[i][j]=1+Math.min(del,Math.min(ins,rep));
        }
    }
    public int minDistance(String word1, String word2) {
        StringBuilder a=new StringBuilder(word1);
        StringBuilder b=new StringBuilder(word2);
        int m=a.length(),n=b.length();
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        return minSteps(m-1,n-1,a,b,dp);
    }
}
//Tabulation
class Solution {
    //tabulation
    public int minDistance(String a, String b) {
        int m = a.length(), n = b.length();
        if(m==0) return n;
        if(n==0) return m;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    dp[i][j] = (i>0 && j>0)?dp[i - 1][j - 1] : ((i==0)? j : i);
                } else {
                    int del = (i>0)?dp[i - 1][j]:j;
                    int ins = (j>0)?dp[i][j - 1]:i;
                    int rep = (i>0 && j>0)?dp[i - 1][j - 1] : ((i==0)? j : i);
                    dp[i][j] = 1 + Math.min(del, Math.min(ins, rep));
                }
            }
        }
        return dp[m-1][n-1];
    }
}
