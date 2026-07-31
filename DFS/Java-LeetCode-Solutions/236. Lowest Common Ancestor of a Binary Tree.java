// Optimal
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode n1, TreeNode n2) {
        if (root == null || root.val == n1.val || root.val == n2.val) {
            return root;
        }

        TreeNode leftLCA = lowestCommonAncestor(root.left, n1, n2);
        TreeNode rightLCA = lowestCommonAncestor(root.right, n1, n2);

        if (leftLCA != null && rightLCA != null) {
            return root;
        }

        return (leftLCA != null) ? leftLCA : rightLCA;
    }
}
// Simple solution , checking if q and q lie in same side or different side
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
