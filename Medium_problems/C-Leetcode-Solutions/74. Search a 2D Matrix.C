//-----------------Brute Force-----------------------
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
// -------------------- Optimised ----------------------
bool searchMatrix(int** arr, int arrSize, int* arrColSize, int target) {
    int i = 0;        
    int j = * arrColSize - 1; 

    while (i < arrSize && j >= 0) {
        if (arr[i][j] == target) {
            return true; 
        } else if (arr[i][j] < target) {
            i++; 
        } else {
            j--; 
        }
    }
    return false; 
}
