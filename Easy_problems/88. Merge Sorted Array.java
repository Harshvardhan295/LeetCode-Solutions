class Solution {
    public void merge(int[] arr, int m, int[] arr2, int n) {
        int[] ans = new int[m+n];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (arr[i] <= arr2[j]) ans[k++] = arr[i++];
            else ans[k++] = arr2[j++];
        }
        while (j < n) ans[k++] = arr2[j++];
        while (i < m) ans[k++] = arr[i++];

        for(int l=0;l<ans.length;l++){
            arr[l]=ans[l];
        }
    
    }
}
