class Solution {
    private int[][] dp = new int[20001][4];

    private int helper(int[] subarray, int k, int idx, int rem) {
        if (rem == 0)
            return 0;
        if (idx >= subarray.length)
            return Integer.MIN_VALUE;

        if (dp[idx][rem] != -1) {
            return dp[idx][rem];
        }

        int take = subarray[idx] + helper(subarray, k, idx + k, rem - 1);
        int notTake = helper(subarray, k, idx + 1, rem);

        dp[idx][rem] = Math.max(take, notTake);
        return dp[idx][rem];
    }

    private void solve(int[] subarray, int k, int idx, int rem, List<Integer> indices) {
        if (rem == 0 || idx >= subarray.length)
            return;

        int take = subarray[idx] + helper(subarray, k, idx + k, rem - 1);
        int notTake = helper(subarray, k, idx + 1, rem);

        if (take >= notTake) {
            indices.add(idx);
            solve(subarray, k, idx + k, rem - 1, indices);
        } else {
            solve(subarray, k, idx + 1, rem, indices);
        }
    }

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int n = nums.length - k + 1;
        int[] subarray = new int[n];
        int windowSum = 0;
        int i = 0, j = 0;

        // Calculate window subarray
        while (j < nums.length) {
            windowSum += nums[j];

            if (j - i + 1 == k) {
                subarray[i] = windowSum;
                windowSum -= nums[i];
                i++;
            }
            j++;
        }

        List<Integer> indices = new ArrayList<>();
        solve(subarray, k, 0, 3, indices);

        // Either this
        // int[] result = new int[indices.size()];
        // for (int x = 0; x < indices.size(); x++) {
        //     result[x] = indices.get(x);
        // }
        // return result;

        // OR 
        return indices.stream().mapToInt(Integer::intValue).toArray();
    }
}
