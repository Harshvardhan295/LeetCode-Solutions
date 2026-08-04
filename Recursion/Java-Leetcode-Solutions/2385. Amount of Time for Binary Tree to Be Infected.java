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
    public void findParent(TreeNode node, TreeNode par, Map<TreeNode, TreeNode> parent) {
        if (node == null)
            return;

        parent.put(node, par);
        findParent(node.left, node, parent);
        findParent(node.right, node, parent);
    }

    public TreeNode findtarget(TreeNode root, int target) {
        if (root == null)
            return null;
        if (root.val == target)
            return root;
        TreeNode left = findtarget(root.left, target);
        if (left != null)
            return left;
        return findtarget(root.right, target);
    }

    public int amountOfTime(TreeNode root, int target) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        findParent(root, null, parent);

        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        TreeNode t = findtarget(root, target);
        if (t == null)
            return 0;

        q.offer(t);
        visited.add(t);
        int ans = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            ans++;

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                if (node.left != null && !visited.contains(node.left)) {
                    visited.add(node.left);
                    q.offer(node.left);
                }

                if (node.right != null && !visited.contains(node.right)) {
                    visited.add(node.right);
                    q.offer(node.right);
                }

                if (parent.get(node) != null && !visited.contains(parent.get(node))) {
                    visited.add(parent.get(node));
                    q.offer(parent.get(node));
                }
            }
        }

        return ans - 1; // Subtract 1 because the final loop iteration does no spreading
    }
}
