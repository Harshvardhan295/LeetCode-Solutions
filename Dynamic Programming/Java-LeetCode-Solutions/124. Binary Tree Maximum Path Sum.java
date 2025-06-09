class Solution {
    public int LineSum(TreeNode root, int[] pathSum) {
        if (root == null)
            return 0;
        int leftLineSum = LineSum(root.left, pathSum);
        int rightLineSum = LineSum(root.right, pathSum);
        int Sum= root.val+leftLineSum + rightLineSum;
        pathSum[0] = Math.max(pathSum[0], Sum);
        return root.val + Math.max(leftLineSum, rightLineSum);
    }
    public int maxPathSum(TreeNode root) {
        int[] pathSum = {0};
        LineSum(root,pathSum);
        return pathSum[0];
    }
}
