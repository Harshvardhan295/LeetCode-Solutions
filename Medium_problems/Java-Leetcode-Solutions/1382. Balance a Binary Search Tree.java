class Solution {
    public static void inorder(TreeNode root, List<TreeNode> arr) {
        if (root == null)
            return;
        inorder(root.left,arr);
        arr.add(root);
        inorder(root.right,arr);
    }
    public TreeNode helper(List<TreeNode> nums, int lo, int hi) {
        if (lo > hi)
            return null;
        int midIdx = (lo+hi) / 2;
        TreeNode root = new TreeNode(nums.get(midIdx).val);
        root.left = helper(nums, lo, midIdx - 1);
        root.right = helper(nums, midIdx + 1, hi);
        return root;
    }

    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> arr = new ArrayList<>();
        inorder(root, arr);
        return helper(arr, 0, arr.size() - 1);
    }
}
