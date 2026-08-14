class Solution {
    int d;

    public int helper(TreeNode node) {
        if (node == null)
            return 0;

        int leftMax = helper(node.left);
        int rightMax = helper(node.right);
        int subtreeMax = Math.max(node.val, Math.max(leftMax, rightMax));

        if (node.val == subtreeMax) {
            d++;
        }

        return subtreeMax;
    }

    public int countDominantNodes(TreeNode root) {
        if (root == null)
            return 0;
        d = 0;
        helper(root);
        return d;
    }
}
