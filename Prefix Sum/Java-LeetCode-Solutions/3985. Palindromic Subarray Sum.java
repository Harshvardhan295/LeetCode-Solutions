class Solution {
    long[] preSum;

    public long getSum(int[] nums) {
        int n = nums.length;
        preSum = new long[n + 1];
        preSum[0] = 0L;

        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + (long) nums[i];
        }

        int[] arr = new int[2 * n + 1];
        int j = 0;
        for (int i = 0; i < arr.length; i += 2) {
            arr[i] = 0;
            if (i + 1 < arr.length)
                arr[i + 1] = nums[j++];
        }

        int[] p = new int[arr.length];

        long maxi = 0;

        int c = 0;
        int r = p[c] + c;

        for (int i = 1; i < arr.length - 1; i++) {

            if (i < r) {
                p[i] = Math.min(r - i, p[2 * c - i]);
            } else {
                p[i] = 0;
            }

            int l_i = i - p[i] - 1;
            int r_i = i + p[i] + 1;

            while (l_i >= 0 && r_i < arr.length && arr[l_i] == arr[r_i]) {
                p[i]++;
                l_i--;
                r_i++;
            }

            if (i + p[i] > r) {
                c = i;
                r = i + p[i];
            }

            int left = (l_i + 2) / 2;
            int right = (r_i - 2) / 2;

            maxi = Math.max(maxi, preSum[right + 1] - preSum[left]);
        }

        return maxi;
    }
}
