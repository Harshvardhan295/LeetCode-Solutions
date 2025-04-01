//Recursion
class Solution {
    public int squares(int[][] arr, int row, int col) {
        if (row < 0 || col < 0 || arr[row][col] == 0) return 0;

        int top = squares(arr, row - 1, col);
        int left = squares(arr, row, col - 1);
        int diagonal = squares(arr, row - 1, col - 1);

        // Current square count is the minimum of the three + 1
        // Minimum tells if there is any zero that i consists
        int squareSize = 1 + Math.min(top, Math.min(left, diagonal));

        return squareSize;
    }

    public int countSquares(int[][] arr) {
        int m = arr.length, n = arr[0].length;
        int count = 0;

        // Recursively count squares for each cell
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                count += squares(arr, i, j);
            }
        }
        return count;
    }
}
//Memoization
class Solution {
    public int squares(int[][] arr, int row, int col,int[][] dp) {
        if (row < 0 || col < 0 || arr[row][col] == 0) return 0;
        if (dp[row][col] != -1) return dp[row][col];

        int top = squares(arr, row - 1, col,dp);
        int left = squares(arr, row, col - 1,dp);
        int diagonal = squares(arr, row - 1, col - 1,dp);

        // Current square count is the minimum of the three + 1
        // Minimum tells if there is any zero that i consists
        return dp[row][col] = 1 + Math.min(top, Math.min(left, diagonal));
    }

    public int countSquares(int[][] arr) {
        int m = arr.length, n = arr[0].length, count = 0;
        int[][] dp = new int[m][n];

        for (int[] row : dp) Arrays.fill(row, -1);

        // Recursively count squares for each cell
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                count += squares(arr, i, j,dp);
            }
        }
        return count;
    }
}
//
