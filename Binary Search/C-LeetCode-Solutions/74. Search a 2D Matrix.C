bool searchMatrix(int** arr, int arrSize, int* arrColSize, int target) {
    int m = arrSize;
    int n = *arrColSize;

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (arr[i][j] == target) {
                return true;
            }

            if (arr[i][j] > target) {
                break;  // No need to check further in this row
            }
        }
    }
    return false;  
}
