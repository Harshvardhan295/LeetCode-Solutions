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
