//Method 1
class Solution {
    public int levels(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(levels(root.left), levels(root.right));
    }

    public void nthLevel(TreeNode root, int level, int n, List<Integer> arr) {
        if (root == null)
            return;

        if (level == n) {
            arr.add(root.val);
            return;
        }

        nthLevel(root.left, level + 1, n, arr);
        nthLevel(root.right, level + 1, n, arr);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = levels(root); // Total number of levels

        // Traverse through all levels
        for (int i = 0; i < n; i++) {
            List<Integer> arr = new ArrayList<>();
            nthLevel(root, 0, i, arr); 
            ans.add(arr);
        }
        return ans;
    }
}

