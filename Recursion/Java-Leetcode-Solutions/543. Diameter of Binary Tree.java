class Solution {
    public int levels(TreeNode root) {
        if (root == null) 
            return 0;
        return 1 + Math.max(levels(root.left), levels(root.right));
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        int diameter = levels(root.left) + levels(root.right);
        int leftHeight = diameterOfBinaryTree(root.left);
        int rightHeight = diameterOfBinaryTree(root.right);
        return Math.max(diameter, Math.max(leftHeight, rightHeight));
    }
}

