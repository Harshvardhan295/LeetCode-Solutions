/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean exists(TreeNode root, TreeNode x) {
        if (root == x)
            return true;
        if (root == null)
            return false;
        return exists(root.left, x) || exists(root.right, x);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;

        boolean pinLeft = exists(root.left, p);
        boolean qinLeft = exists(root.left, q);

        if (pinLeft && qinLeft) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (!pinLeft && !qinLeft) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
}
