class Solution {
    public TreeNode helper(int[] nums, int lo, int hi) {
        if (lo > hi)
            return null;
        int midIdx = (lo+hi) / 2;
        TreeNode root = new TreeNode(nums[midIdx]);
        root.left = helper(nums, lo, midIdx - 1);
        root.right = helper(nums, midIdx + 1, hi);
        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }
}
