// YT method
// https://www.youtube.com/watch?v=Q2kDj7gy9_8 (video solution)
class Solution {
    long total = 0;
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // compute total
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                total += grid[i][j];
            }
        }

        // Horizontal
        if (checkHorCuts(grid)) return true;

        reverse(grid);

        if (checkHorCuts(grid)) return true;

        reverse(grid);

        // Transpose
        int[][] transposeGrid = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                transposeGrid[j][i] = grid[i][j];
            }
        }

        if (checkHorCuts(transposeGrid)) return true;

        reverse(transposeGrid);

        return checkHorCuts(transposeGrid);
    }

    public boolean checkHorCuts(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        HashSet<Long> set = new HashSet<>();
        long top = 0;

        for (int i = 0; i < m - 1; i++) {

            for (int j = 0; j < n; j++) {
                set.add((long)grid[i][j]);
                top += grid[i][j];
            }

            long bottom = total - top;
            long diff = top - bottom;

            if (diff == 0) return true;

            if (diff == grid[0][0]) return true;
            if (diff == grid[0][n - 1]) return true;
            if (diff == grid[i][0]) return true;

            if (i > 0 && n > 1 && set.contains(diff)) {
                return true;
            }
        }

        return false;
    }

    // Helper to reverse rows
    private void reverse(int[][] grid) {
        int top = 0, bottom = grid.length - 1;

        while (top < bottom) {
            int[] temp = grid[top];
            grid[top] = grid[bottom];
            grid[bottom] = temp;

            top++;
            bottom--;
        }
    }
}
//Method 2
import java.util.*;

class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        long total = 0;

        HashMap<Long, Integer> top = new HashMap<>();
        HashMap<Long, Integer> bottom = new HashMap<>();
        HashMap<Long, Integer> left = new HashMap<>();
        HashMap<Long, Integer> right = new HashMap<>();

        // Initialize bottom & right
        for (int[] row : grid) {
            for (int val : row) {
                total += val;
                bottom.put((long) val, bottom.getOrDefault((long) val, 0) + 1);
                right.put((long) val, right.getOrDefault((long) val, 0) + 1);
            }
        }

        long sumTop = 0;

        // Horizontal cuts
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n; j++) {
                int val = grid[i][j];

                sumTop += val;

                top.put((long) val, top.getOrDefault((long) val, 0) + 1);
                bottom.put((long) val, bottom.get((long) val) - 1);
            }

            long sumBottom = total - sumTop;

            if (sumTop == sumBottom) return true;

            long diff = Math.abs(sumTop - sumBottom);

            if (sumTop > sumBottom) {
                if (check(top, grid, 0, i, 0, n - 1, diff)) return true;
            } else {
                if (check(bottom, grid, i + 1, m - 1, 0, n - 1, diff)) return true;
            }
        }

        long sumLeft = 0;

        // Vertical cuts
        for (int j = 0; j < n - 1; j++) {
            for (int i = 0; i < m; i++) {
                int val = grid[i][j];

                sumLeft += val;

                left.put((long) val, left.getOrDefault((long) val, 0) + 1);
                right.put((long) val, right.get((long) val) - 1);
            }

            long sumRight = total - sumLeft;

            if (sumLeft == sumRight) return true;

            long diff = Math.abs(sumLeft - sumRight);

            if (sumLeft > sumRight) {
                if (check(left, grid, 0, m - 1, 0, j, diff)) return true;
            } else {
                if (check(right, grid, 0, m - 1, j + 1, n - 1, diff)) return true;
            }
        }

        return false;
    }

    // CORE CHECK FUNCTION
    public boolean check(HashMap<Long, Integer> mp, int[][] grid,
                          int r1, int r2, int c1, int c2, long diff) {

        int rows = r2 - r1 + 1;
        int cols = c2 - c1 + 1;

        // cannot remove if only one cell
        if (rows * cols == 1) return false;

        // 1D row
        // if the ele is in start or end of that row
        // then connectivity does not breaks
        if (rows == 1) {
            return grid[r1][c1] == diff || grid[r1][c2] == diff;
        }

        // 1D column
        //if the ele is in start or end of that col
        // then connectivity does not breaks
        if (cols == 1) {
            return grid[r1][c1] == diff || grid[r2][c1] == diff;
        }

        // 2D grid → just check existence
        return mp.getOrDefault(diff, 0) > 0;
    }
}
