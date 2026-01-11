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
    int maxLevel = 0;
    public void dfs(TreeNode root, int level, int[] sum) {
        if (root == null) return;

        sum[level] += root.val;
        maxLevel = Math.max(maxLevel, level);

        dfs(root.left, level + 1, sum);
        dfs(root.right, level + 1, sum);
    }

    public int maxLevelSum(TreeNode root) {
        int[] sum = new int[10001]; // safe limit
        dfs(root, 0, sum);

        int maxSum = Integer.MIN_VALUE;
        int ans = 0;

        for (int i = 0; i <= maxLevel; i++) {
            if (sum[i] > maxSum) {
                maxSum = sum[i];
                ans = i;
            }
        }
        return ans + 1;
    }
}
