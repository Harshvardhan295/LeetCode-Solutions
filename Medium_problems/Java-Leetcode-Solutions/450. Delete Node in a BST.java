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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }
        else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }
        // Found target
        else {
            // Case 1: No children (leaf)
            if (root.left == null && root.right == null) {
                return null;
            }
            // Case 2: One child
            if (root.left == null || root.right == null) {
                return root.left != null ? root.left : root.right;
            }
            // Case 3: Two children
            // 1. Get min from right
            root.val = findMin(root.right);
            // 2. Delete duplicate
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    // Finding leftmost leaf or inorder succesor
    public static int findMin(TreeNode root) {
        if (root.left == null) return root.val;
        return findMin(root.left);
    }
}
