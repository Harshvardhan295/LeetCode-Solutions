class Solution {
    public int countQuadruplets(int[] arr) {
        int n = arr.length, ans = 0;

        for (int i = 0; i < n - 3; i++) {
            int first = arr[i];
            for (int j = i + 1; j < n - 2; j++) {
                int second = arr[j];
                for (int k = j + 1; k < n - 1; k++) {
                    int third = arr[k];
                    for (int l = k + 1; l < n; l++) {
                        int fourth = arr[l];
                        if (first + second + third == fourth)
                            ans++;
                    }
                }
            }
        }
        return ans;
    }
}
