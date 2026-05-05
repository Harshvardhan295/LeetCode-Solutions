//Optimised approach
class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        k = k % n;
        if (k == 0)
            return true;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != mat[i][(j - k + n) % n]) {
                    return false;
                }
            }
        }
        return true;
    }
}
//My approach
class Solution {
    public void leftShift(int[] arr, int k) {
        while (k > 0) {
            int temp = arr[0];
            int idx = 0;
            while (idx < arr.length - 1) {
                arr[idx] = arr[idx + 1];
                idx++;
            }
            arr[arr.length - 1] = temp;
            k--;
        }
    }

    public void rightShift(int[] arr, int k) {
        while (k > 0) {
            int temp = arr[arr.length - 1];
            int idx = arr.length - 1;
            while (idx > 0) {
                arr[idx] = arr[idx - 1];
                idx--;
            }
            arr[0] = temp;
            k--;
        }
    }

    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = mat[i][j];
            }
        }
        k = k % n;
        int idx = 0;
        for (int[] row : mat) {
            if (idx % 2 == 0) {
                leftShift(row, k);
            } else {
                rightShift(row, k);
            }
            idx++;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] != mat[i][j])
                    return false;
            }
        }
        return true;
    }
}
