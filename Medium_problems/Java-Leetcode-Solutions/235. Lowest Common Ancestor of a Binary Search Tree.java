//Method 1
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);
        else if (root.val > p.val && root.val >q.val)
            return lowestCommonAncestor(root.left, p, q);
        else{
            return root;
        }
    }
}
//Method 2
class Solution {
    static int sum=0;
    public static void reverseInorder(TreeNode root) {
        if (root == null)
            return;
        reverseInorder(root.right);
        root.val+=sum;
        sum=root.val;
        reverseInorder(root.left);
    }

    public TreeNode bstToGst(TreeNode root) {
        sum = 0;
        reverseInorder(root);
        return root;
    }
}
