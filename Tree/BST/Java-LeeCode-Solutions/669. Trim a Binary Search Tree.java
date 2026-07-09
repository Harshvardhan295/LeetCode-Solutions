/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;

        //curr value is too small, all on its left is also too small.
        //Discard this node and its left side, check its right side.
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }

        //curr value is too large, all on its right is also too large.
        //Discard this node and its right side, check its left side.
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }

        //curr value is valid, recursively trim its left and right children
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        return root;
    }
}
