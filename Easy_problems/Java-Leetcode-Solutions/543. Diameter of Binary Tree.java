// Brute Force
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
// Optimised
class Solution {
    public int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        calculateHeight(root);
        return diameter;
    }
    private int calculateHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);
        diameter = Math.max(diameter, leftHeight + rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
// Optimised Code
class Solution {
    public int levels(TreeNode root, int[] maxDia) {
        if (root == null)
            return 0;
        int leftHeight = levels(root.left, maxDia);
        int rightHeight = levels(root.right, maxDia);
        int diameter = leftHeight + rightHeight;
        maxDia[0] = Math.max(diameter, maxDia[0]);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        int[] maxDia = {0};
        levels(root, maxDia);
        return maxDia[0];
    }
}
