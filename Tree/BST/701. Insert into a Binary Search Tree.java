class Solution {
    public TreeNode helper(TreeNode root, int val,TreeNode node) {
        if (root == null)
            return node;
        if (root.val < val) {
            root.right = helper(root.right, val,node);
        } else {
            root.left = helper(root.left, val,node);
        }
        return root;
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node=new TreeNode(val);
         if (root == null)
            return node;
        return helper(root, val,node);
    }
}
