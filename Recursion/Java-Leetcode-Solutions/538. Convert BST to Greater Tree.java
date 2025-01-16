class Solution {
    public static void inorder(TreeNode root, List<TreeNode> arr) {
        if (root == null)
            return;
        inorder(root.left,arr);
        arr.add(root);
        inorder(root.right,arr);
    }

        public TreeNode convertBST(TreeNode root) {
        List<TreeNode> arr = new ArrayList<>();
        inorder(root, arr);
        for (int i = arr.size() - 2; i >= 0; i--) {
            arr.get(i).val += arr.get(i + 1).val;
        }
        return root;
    }
}

