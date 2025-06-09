class Solution {
    public int LineSum(TreeNode root, int[] pathSum) {
        if (root == null)
            return 0;
        int leftLineSum = LineSum(root.left, pathSum);
        int rightLineSum = LineSum(root.right, pathSum);
        int Sum= root.val;
        if(leftLineSum>0) Sum+=leftLineSum ;
        if(rightLineSum>0) Sum+=rightLineSum;
        pathSum[0] = Math.max(pathSum[0], Sum);
        return root.val + Math.max(0,Math.max(leftLineSum, rightLineSum));
    }
    public int maxPathSum(TreeNode root) {
        int[] pathSum = {Integer.MIN_VALUE};
        LineSum(root,pathSum);
        return pathSum[0];
    }
}
