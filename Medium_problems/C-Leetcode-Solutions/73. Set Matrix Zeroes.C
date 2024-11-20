void setZeroes(int** arr, int arrSize, int* arrColSize) {
    int m = arrSize, n = *arrColSize;

    int* rowFlags = (int*)calloc(m, sizeof(int)); // Rows to be zeroed
    int* colFlags = (int*)calloc(n, sizeof(int)); // Columns to be zeroed

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (arr[i][j] == 0) {
                rowFlags[i] = 1; 
                colFlags[j] = 1; 
            }
        }
    }

    for (int i = 0; i < m; i++) {
        if (rowFlags[i]) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = 0;
            }
        }
    }

    for (int j = 0; j < n; j++) {
        if (colFlags[j]) {
            for (int i = 0; i < m; i++) {
                arr[i][j] = 0;
            }
        }
    }

    free(rowFlags);
    free(colFlags);
}

