//Recursion
class Solution {
    private int uniquePathsWithObstacles(int[][] arr, int row, int col) {
        int m = arr.length;
        int n = arr[0].length;

        if (arr[0][0] == 1 || arr[m - 1][n - 1] == 1) {
            return 0;
        }

        if (row == m - 1 && col == n - 1) {
            return 1;
        }

        if (row >= m || col >= n || arr[row][col] == 1) {
            return 0;
        }

        int rightWays = uniquePathsWithObstacles(arr, row, col + 1);
        int downWays = uniquePathsWithObstacles(arr, row + 1, col);

        return rightWays + downWays;
    }
    public int uniquePathsWithObstacles(int[][] arr) {
        return uniquePathsWithObstacles(arr, 0, 0); //same method name but with different arguments
    }
}
//Memoization
class Solution {
    private int uniquePathsWithObstacles(int[][] arr, int row, int col,int[][] dp) {
        int m = arr.length;
        int n = arr[0].length;

        if (arr[0][0]== 1 || arr[m-1][n-1]== 1) return 0;//start and goal is obstacle
        if (row == m - 1 && col == n - 1) return 1;
        if (row >= m || col >= n || arr[row][col] == 1) return 0;
        
        if(dp[row][col]!=-1) return dp[row][col];
        int rightWays = uniquePathsWithObstacles(arr, row, col + 1,dp);
        int downWays = uniquePathsWithObstacles(arr, row + 1, col,dp);
        
        return dp[row][col]=rightWays + downWays;
    }
    public int uniquePathsWithObstacles(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        return uniquePathsWithObstacles(arr, 0, 0,dp); //same method name but with different arguments
    }   
}
