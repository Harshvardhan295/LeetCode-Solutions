class Solution {
    public int[][] reverseSubmatrix(int[][] arr, int x, int y, int k) {
        int n = arr.length;
        int m = arr[0].length;
        int firstrow = x, lastrow = x + k - 1, firstcol = y;
        while (firstrow < lastrow) {
            for (int j = y; j < y + k; j++) {
                int temp = arr[firstrow][j];
                arr[firstrow][j] = arr[lastrow][j];
                arr[lastrow][j] = temp;
            }
            firstrow++;
            lastrow--;
        }
        return arr;
    }
}
