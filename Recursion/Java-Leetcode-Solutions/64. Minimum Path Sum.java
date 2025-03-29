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
