class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] arr = new int[n * m];
        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[k++] = grid[i][j];
            }
        }
        int[] prefix = new int[n * m];
        prefix[0] = 1;
        for (int i = 1; i < n * m; i++) {
            prefix[i] = (int) ((long) arr[i - 1] * prefix[i - 1] % 12345);
        }

        int suffixProd = 1;
        int[] result= new int[n*m];
        for (int i = n * m - 1; i >= 0; i--) {
            result[i] = (int) ((long) prefix[i] * suffixProd % 12345);
            suffixProd = (int) ((long) suffixProd * arr[i] % 12345);
        }

        k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = result[k++];
            }
        }
        return grid;
    }
}
