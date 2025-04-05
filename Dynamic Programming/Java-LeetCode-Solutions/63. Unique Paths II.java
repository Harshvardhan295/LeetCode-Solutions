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
//Tabulation
class Solution {
    public int uniquePathsWithObstacles(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        if (arr[0][0] == 1 || arr[m - 1][n - 1] == 1) return 0;//start and goal is obstacle

        arr[0][0] = 1;

        //Convert the first row and first column to 0 if obstacle and 1 if not
        for (int i = 1; i < m; i++) {
            if (arr[i][0] == 1) arr[i][0] = 0;//If obstacle, set it to 0
            else arr[i][0] = arr[i-1][0];
        }
        for (int i = 1; i < n; i++) {
            if (arr[0][i] == 1) arr[0][i] = 0;//If obstacle, set it to 0
            else arr[0][i] = arr[0][i-1];
        }

        //for rest of the matrix
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (arr[i][j] == 1) arr[i][j] = 0;//If obstacle, set it to 0
                else arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
            }
        }
        return arr[m - 1][n - 1];
    }
}
