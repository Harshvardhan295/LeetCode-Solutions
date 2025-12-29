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
    public int minimumDeleteSum(String word1, String word2) {
        StringBuilder a=new StringBuilder(word1);
        StringBuilder b=new StringBuilder(word2);
        int m=a.length(),n=b.length();
        return minSteps(m-1,n-1,a,b);
    }
}
//Memoization
class Solution {
    int[][] dp;

    public int helper(String s1, String s2, int i, int j, int m, int n) {
        if (i == m && j == n) return 0;
        if (i == m) return s2.charAt(j) + helper(s1, s2, i, j+1, m, n);
        if (j == n) return s1.charAt(i) + helper(s1, s2, i+1, j, m, n);

        if (dp[i][j] != -1) return dp[i][j];

        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = helper(s1, s2, i+1, j+1, m, n);
        }

        int del1 = s1.charAt(i) + helper(s1, s2, i+1, j, m, n);
        int del2 = s2.charAt(j) + helper(s1, s2, i, j+1, m, n);

        return dp[i][j] = Math.min(del1, del2);
    }

    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        dp = new int[m][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        return helper(s1, s2, 0, 0, m, n);
    }
}
