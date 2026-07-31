//DFS
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {
        // If both subtrees are empty, they are symmetric
        if (t1 == null && t2 == null) return true;
        
        // If only one is empty, they are not symmetric
        if (t1 == null || t2 == null) return false;
        
        // Check if current values match AND their subtrees are mirrored
        return (t1.val == t2.val)
            && isMirror(t1.left, t2.right)
            && isMirror(t1.right, t2.left);
    }
}
// Using Invert Tree
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        if(root.left==null && root.right==null) return root;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        // if(p!=null && q==null) return false;
        // if(p==null && q!=null) return false;
        if (p == null || q == null)
            return false;
        if (p.val != q.val)
            return false;
        if (!isSameTree(p.left, q.left))
            return false;
        if (!isSameTree(p.right, q.right))
            return false;
        return true;
    }
    public boolean isSymmetric(TreeNode root) {
        
        invertTree(root.right);
        boolean result=isSameTree(root.left,root.right);
        invertTree(root.right);

        return result;
    }
}
