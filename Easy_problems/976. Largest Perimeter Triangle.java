class Solution {
    public static void merge(int[] arr1, int[] arr2, int[] ans) {
        int m = arr1.length;
        int n = arr2.length;
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (arr1[i] <= arr2[j]) ans[k++] = arr1[i++];
            else ans[k++] = arr2[j++];
        }
        while (j < n) ans[k++] = arr2[j++];
        while (i < m) ans[k++] = arr1[i++];
    }

    public static void merge_sort(int[] arr) {
        int n = arr.length;
        if (n == 1) return; // base case
        int[] a = new int[n / 2];
        int[] b = new int[n - n / 2];

        for (int i = 0; i < n / 2; i++) a[i] = arr[i]; // copy to smaller arrays
        for (int i = 0; i < n - n / 2; i++) b[i] = arr[i + n / 2];

        // Recursively sort subarrays
        merge_sort(a);
        merge_sort(b);

        // Merge sorted subarrays
        merge(a, b, arr);

        // Deallocate arrays (handled by GC in Java, but nullifying for clarity)
        a = null;
        b = null;
    }

    public int largestPerimeter(int[] nums) {
        // Arrays.sort(nums);
        merge_sort(nums);
        for(int i=nums.length-1;i>=2;i--){
            if(nums[i-2]+nums[i-1]>nums[i]){
               return nums[i-2]+nums[i-1]+nums[i];
            }
        }
        return 0;
    }
}
