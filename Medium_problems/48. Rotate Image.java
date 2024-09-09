class Solution {
    public void rotate(int[][] arr) {
        int m = arr.length;//rows
        int n = arr[0].length;
        int[][] transpose = new int[n][m];
//Transpose array
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                transpose[i][j] = arr[j][i];
            }
        }
        //Reverse the array to get it rotate by 90 degree
        for (int i = 0; i < transpose.length; i++) {
            int a = 0;//starting element of the first row of the array
            int b = m - 1;//last element of the first row of the array
            while (a < b) {
                int temp = transpose[i][a];
                transpose[i][a] = transpose[i][b];
                transpose[i][b] = temp;
                a++;
                b--;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = transpose[i][j];
            }
        }

    }
}
