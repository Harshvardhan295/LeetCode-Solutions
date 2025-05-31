//HashMap with Memoization
class Solution {
    public static int levels(TreeNode root,Map<TreeNode,Integer> dp) {
        if (root == null)
            return 0;
        int leftHeight = levels(root.left, dp);
        int rightHeight = levels(root.right, dp);
        dp.put(root,1 + Math.max(leftHeight,rightHeight));
        return dp.get(root);
    }
    public boolean checkBalance(TreeNode root, Map<TreeNode,Integer> dp){
        if (root == null)
            return true;
        int diff=Math.abs(levels(root.left,dp)-levels(root.right,dp));
        if(diff>1) return false;
        return checkBalance(root.left,dp) && checkBalance(root.right,dp);
    }
    public boolean isBalanced(TreeNode root) {
        Map<TreeNode,Integer> dp=new HashMap<>();
        return checkBalance(root,dp);
    }
}
//brute force-recursion
class Solution {
    public static int levels(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(levels(root.left), levels(root.right));
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        int diff=Math.abs(levels(root.left)-levels(root.right));
        if(diff>1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
}
//Optimised code using array
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
