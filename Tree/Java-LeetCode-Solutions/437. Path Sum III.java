class Solution {
    public static int helper(TreeNode root, long sum) {
        if (root == null) return 0;
        int paths = 0;
        if (root.val == sum) paths++;
        paths+=helper(root.left,sum - root.val) + helper(root.right,sum- root.val);
        return paths; 
    }

    public int pathSum(TreeNode root, int targetSum) {
        if(root==null) return 0;
        return helper(root, targetSum)+pathSum(root.left, targetSum)+pathSum(root.right, targetSum);
    }
}
