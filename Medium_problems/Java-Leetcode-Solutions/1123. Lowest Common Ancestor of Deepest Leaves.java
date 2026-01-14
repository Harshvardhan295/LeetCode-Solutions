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
    int height = 0;
    TreeNode ans;
    public int levels(TreeNode node) {
        if (node == null) return 0;
        int left_height = levels(node.left);
        int right_height = levels(node.right);
        return Math.max(left_height, right_height) + 1;
    }

    // LCA
    public boolean dfs(TreeNode node, int depth) {
        if (node == null) return false;
        if (depth == height) {
            ans = node;  // mark it as ans in case it's the only deepest node
            return true;  
        }

        boolean left = dfs(node.left, depth + 1);
        boolean right = dfs(node.right, depth + 1);

        // Current node has deepest nodes in both left and right subtree → LCA
        if (left && right) {
            ans = node;
            return true;
        }

        return left || right;  // deepest node is present in only one of the subtrees
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        height = levels(root);
        // DFS to find the smallest subtree containing all deepest nodes
        boolean a=dfs(root, 1);
        System.out.println(a);
        return ans;
    }
}
