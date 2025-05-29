class Solution {
    public static String lcs(String a, String b) {
    int m = a.length(), n = b.length();
    int[][] dp = new int[m + 1][n + 1];

    for (int i = 1; i <= m; i++) {//LCS logic
        for (int j = 1; j <= n; j++) {
            if (a.charAt(i - 1) == b.charAt(j - 1)) {
                dp[i][j] = 1 + dp[i - 1][j - 1];
            } else {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
    }

    // Backtrack to get the LCS string
    StringBuilder lcs = new StringBuilder();
    int i = m, j = n;
    while (i > 0 && j > 0) {
        if (a.charAt(i - 1) == b.charAt(j - 1)) {
            lcs.append(a.charAt(i - 1));
            i--;j--; //move diagonally
        } else if (dp[i - 1][j] > dp[i][j - 1]) {
            i--;//move up
        } else {
            j--;//move left
        }
    }

    return lcs.reverse().toString();  // reverse to correct order
}

    public String shortestCommonSupersequence(String a, String b) {
        String common=lcs(a,b);
        StringBuilder ans=new StringBuilder("");
        int i=0,j=0,k=0;//i=a,j=b,k=common
        while(i<a.length() && j<b.length() && k<common.length()){
            while(a.charAt(i)!=common.charAt(k)){
                ans.append(a.charAt(i));
                i++;
            }
            while(b.charAt(j)!=common.charAt(k)){
                ans.append(b.charAt(j));
                j++;
            }
            ans.append(common.charAt(k)); i++;j++;k++;
        }
        while(i<a.length()) {
            ans.append(a.charAt(i));
            i++;
        }
        while(j<b.length()) {
            ans.append(b.charAt(j));
            j++;
        }
        return ans.toString();
    }
}
