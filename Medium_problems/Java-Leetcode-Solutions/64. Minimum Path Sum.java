//Recursion
class Solution {
    public int path(int[][] grid, int i, int j, int m, int n) {
        if (i >= m || j >= n) return Integer.MAX_VALUE; 
        if (i == m - 1 && j == n - 1) return grid[i][j]; 
        int right = path(grid, i, j + 1, m, n); 
        int down = path(grid, i + 1, j, m, n);  
        return grid[i][j] + Math.min(right, down);
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        return path(grid, 0, 0, m, n);
    }
}
//Tabulation
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) grid[i][j] = grid[i][j];
                else if (i == 0) grid[i][j] += grid[i][j - 1];
                else if (j == 0) grid[i][j] += grid[i - 1][j];
                else grid[i][j] += Math.min(grid[i][j - 1], grid[i - 1][j]);
            }
        }
        return grid[m - 1][n - 1];
    }
}
//memoization
class Solution {
    public int path(int[][] grid, int i, int j, int m, int n, int[][] dp) {
        if (i >= m || j >= n) return Integer.MAX_VALUE; 
        if (i == m - 1 && j == n - 1) return grid[i][j]; 
        if (dp[i][j] != -1) return dp[i][j]; 
        
        int right = path(grid, i, j + 1, m, n, dp); 
        int down = path(grid, i + 1, j, m, n, dp);  

        return dp[i][j] = grid[i][j] + Math.min(right, down);
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1); 
        }
        return path(grid, 0, 0, m, n, dp);
    }
}
