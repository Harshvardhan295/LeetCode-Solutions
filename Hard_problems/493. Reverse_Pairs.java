class Solution {
    static int count;

public static void inversion(int[] a,int[] b){
    int i=0,j=0;
    while(i<a.length&& j<b.length){
        if((long)a[i]>(long)2*(long)b[j]){
            count+=(a.length-i);
            j++;
        }
        else i++;
    }
}
    public static void merge(int[] arr, int[] arr2, int[] ans) {
        int m = arr.length;
        int n = arr2.length;
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (arr[i] <= arr2[j]) ans[k++] = arr[i++];
            else {
                ans[k++] = arr2[j++];
            }
        }
        while (j < n) ans[k++] = arr2[j++];
        while (i < m) ans[k++] = arr[i++];
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
        inversion(a,b);
        // Merge sorted subarrays
        merge(a, b, arr);

        // Deallocate arrays (handled by GC in Java, but nullifying for clarity)
        a = null;
        b = null;
    }
    public int reversePairs(int[] nums) {
         count=0;
         merge_sort(nums);
         return count;
    }
}
