class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        
        int startCol = 0;
        int endCol = m - 1;

        while (startCol <= endCol) {
            int midCol = startCol + (endCol - startCol) / 2;
            
            // Find the row with the maximum element in the current midCol
            int maxRow = 0;
            for (int i = 0; i < n; i++) {
                if (mat[i][midCol] > mat[maxRow][midCol]) {
                    maxRow = i;
                }
            }
            
            // Check Left Neighbor
            boolean isLeftBig = midCol > 0 && mat[maxRow][midCol - 1] > mat[maxRow][midCol];
            // Check Right Neighbor
            boolean isRightBig = midCol < m - 1 && mat[maxRow][midCol + 1] > mat[maxRow][midCol];

            if (isLeftBig) {
                endCol = midCol - 1;
            } else if (isRightBig) {
                startCol = midCol + 1;
            } else {
                return new int[]{maxRow, midCol};
            }
        }
        
        return new int[]{-1, -1};
    }
}
