class Solution {
    public static int levels(TreeNode root,boolean[] ans) {
        if (root == null)
            return 0;
        int leftlevels=levels(root.left,ans);
        int rightlevels=levels(root.right,ans);
        int diff=Math.abs(leftlevels-rightlevels);
        if(diff>1) ans[0]=false;
        return 1 + Math.max(leftlevels,rightlevels);
    }

    public boolean isBalanced(TreeNode root) {
        boolean[] ans={true};
        levels(root,ans);
        return ans[0];
    }
}
