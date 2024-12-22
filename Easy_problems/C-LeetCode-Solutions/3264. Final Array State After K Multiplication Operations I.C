
/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* getFinalState(int* nums, int numsSize, int k, int multiplier,
                   int* returnSize) {
    while (k > 0) {
        int min = INT_MAX;
        int minIdx = -1;

        for (int i = 0; i < numsSize; i++) {
            if (nums[i] < min) {
                min = nums[i];
                minIdx = i;
            }
        }

        nums[minIdx] = nums[minIdx] * multiplier;

        k--;
    }

    *returnSize = numsSize;
    return nums;
}
