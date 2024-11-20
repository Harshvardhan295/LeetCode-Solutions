class Solution {
    public void setZeroes(int[][] arr) {
        //--------------METHOD 1-------------
        // int m=arr.length, n=arr[0].length;
        // int[][] array=new int[m][n];
        // for(int i=0;i<m;i++){
        //     for(int j=0;j<n;j++){
        //         array[i][j]=arr[i][j];
        //     }
        // }
        // for (int i=0;i<m;i++){
        //     for(int j=0;j<n;j++){
        //         if (array[i][j]==0){
        //             for(int l=0;l<n;l++){
        //                 arr[i][l]=0;
        //             }
        //             for(int k=0;k<m;k++){
        //                 arr[k][j]=0;
        //             }
                
        //         }
        //     }
        
        // ---------------METHOD 2------------------
    //     int m = arr.length, n = arr[0].length;
    //     boolean[] row = new boolean[m];
    //     boolean[] col = new boolean[n];

    //     // First pass: find all rows and columns that need to be set to zero
    //     for (int i = 0; i < m; i++) {
    //         for (int j = 0; j < n; j++) {
    //             if (arr[i][j] == 0) {
    //                 row[i] = true;
    //                 col[j] = true;
    //             }
    //         }
    //     }

    //     // Second pass: set the rows and columns to zero
    //     for (int i = 0; i < m; i++) {
    //         for (int j = 0; j < n; j++) {
    //             if (row[i]==true || col[j]==true) {
    //                 arr[i][j] = 0;
    //             }
    //         }
    //     }
    int m = arr.length;
        int n = arr[0].length;
        boolean firstRowHasZero = false;
        boolean firstColHasZero = false;

        // Check if the first row has any zeroes
        for (int j = 0; j < n; j++) {
            if (arr[0][j] == 0) {
                firstRowHasZero = true;
                break;
            }
        }

        // Check if the first column has any zeroes
        for (int i = 0; i < m; i++) {
            if (arr[i][0] == 0) {
                firstColHasZero = true;
                break;
            }
        }

        // Use first row and first column to mark zeroes
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (arr[i][j] == 0) {
                    arr[i][0] = 0;
                    arr[0][j] = 0;
                }
            }
        }

        // Zero out cells based on marks in the first row and column
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (arr[i][0] == 0 || arr[0][j] == 0) {
                    arr[i][j] = 0;
                }
            }
        }

        // Zero out the first row if necessary
        if (firstRowHasZero) {
            for (int j = 0; j < n; j++) {
                arr[0][j] = 0;
            }
        }

        // Zero out the first column if necessary
        if (firstColHasZero) {
            for (int i = 0; i < m; i++) {
                arr[i][0] = 0;
            }
        }
    }
}

    
