class Solution {
    int gcdByEuclidsAlgorithm(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return gcdByEuclidsAlgorithm(n2, n1 % n2);
    }

    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        pre[0] = nums[0];

        for (int i = 1; i < n; i++) {
            pre[i] = Math.max(pre[i - 1], nums[i]);
        }

        for (int i = 0; i < n; i++) {
            pre[i] = gcdByEuclidsAlgorithm(nums[i], pre[i]);
        }

        Arrays.sort(pre);
        long ans = 0; 
        int i = 0, j = n - 1;
        while (i < j) {
            ans += gcdByEuclidsAlgorithm(pre[i++], pre[j--]);
        }

        return ans;
    }
}
