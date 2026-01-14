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
    int MOD = 1_000_000_007;
    long totalSum = 0;
    long maxProduct = 0;

    // total tree sum
    long getTotalSum(TreeNode root) {
        if (root == null) return 0;
        return root.val 
             + getTotalSum(root.left) 
             + getTotalSum(root.right);
    }

    // Second DFS postorder: compute subtree sums
    long dfs(TreeNode root) {
        if (root == null) return 0;
        // Current subtree sum
        long subSum = root.val + dfs(root.left) + dfs(root.right);

        // Try splitting above this node
        long product = subSum * (totalSum - subSum);
        maxProduct = Math.max(maxProduct, product);

        return subSum;
    }

    public int maxProduct(TreeNode root) {
        totalSum = getTotalSum(root); // O(n)
        dfs(root);                    // O(n)
        return (int)(maxProduct % MOD);
    }
}
