/***********Without Binary Search ************/
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0, j = 0, k = 0;
        int m = nums1.length;
        int n = nums2.length;

        int[] mergedArray = new int[m + n];
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                mergedArray[k++] = nums1[i++];
            } else {
                mergedArray[k++] = nums2[j++];
            }
        }
        
        while (i < m) {
            mergedArray[k++] = nums1[i++];
        }
        
        while (j < n) {
            mergedArray[k++] = nums2[j++];
        }
        int len = mergedArray.length;
        if ((len) % 2 != 0) {// Odd length
            return mergedArray[len / 2];
        } else {// else
            return (mergedArray[len / 2] + mergedArray[(len / 2) - 1]) / 2.0;
        }
    }
}
