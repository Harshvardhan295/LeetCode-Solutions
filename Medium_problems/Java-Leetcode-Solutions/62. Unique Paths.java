//Recursion
class Solution {
    public int ways(int row, int col, int m, int n) {
        if (row == m - 1 && col == n - 1)
            return 1;
        if (row >= m || col >= n)
            return 0;
        return ways(row + 1, col, m, n) + ways(row, col + 1, m, n);
    }

    public int uniquePaths(int m, int n) {
        return ways(0, 0, m, n); // both works
    }
}
//memoization
class Solution {
    public int ways(int row, int col, int m, int n,int[][] dp) {
        if (row == m - 1 && col == n - 1)
            return 1;
        if (row >= m || col >= n)
            return 0;
        if(dp[row][col]!=-1) return dp[row][col];
        return dp[row][col]=ways(row + 1, col, m, n,dp) + ways(row, col + 1, m, n,dp);
    }

    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        return ways(0, 0, m, n,dp); // both works
    }
}
