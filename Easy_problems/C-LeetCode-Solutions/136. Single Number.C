int singleNumber(int* nums, int n) {
    for (int i = 0; i < n; i++) {
        int flag = 1;
        for (int j = 0; j < n; j++) {
            if (i != j && nums[i] == nums[j]) {
                flag = 0; 
                break;
            }
        }
        if (flag == 1) { 
            return nums[i];
        }
    }
    return -1; 
}
