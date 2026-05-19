class Solution {
    public int[] xorQueries(int[] arr, int[][] q) {
        int m = arr.length, n = q.length;;
        for (int i = 1; i < m; i++) {
            arr[i] = arr[i - 1] ^ arr[i];
        }
        int[] ans=new int[n];
        for (int i = 0; i < n; i++) {
            int left=q[i][0],right = q[i][1];
            if (left==0) ans[i] = arr[right];
            else  ans[i] = arr[left-1] ^ arr[right];
        }
        return ans;
    }
}
