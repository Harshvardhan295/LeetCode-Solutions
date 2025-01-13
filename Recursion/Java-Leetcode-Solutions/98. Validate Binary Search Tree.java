//Method 1
class Solution {
    public long max(TreeNode root){
        if(root==null) return Long.MIN_VALUE;
        long a=root.val,b=max(root.left),c=max(root.right);
        return Math.max(a,Math.max(b,c));
    }
    public long min(TreeNode root){
        if(root==null) return Long.MAX_VALUE;
        long a=root.val,b=min(root.left),c=min(root.right);
        return Math.min(a,Math.min(b,c));
    }
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        if(root.val>=min(root.right)) return false;
        if(root.val<=max(root.left)) return false;
        return isValidBST(root.left) && isValidBST(root.right);
    }
}
//Method 2 
class Solution {
    public void inorder(TreeNode root, List<Integer> arr) {
        if (root == null)
            return;
        inorder(root.left,arr);
        arr.add(root.val);
        inorder(root.right,arr);
    }

    public boolean isValidBST(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        inorder(root, arr);
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) <= arr.get(i - 1))
                return false;
        }
        return true;
    }
}
// Method 3: Optimal Code
class Solution {
    public boolean flag;

    public long max(TreeNode root) {
        if (root == null)
            return Long.MIN_VALUE;
        long b = max(root.left);
        if (b >= root.val)
            flag = false;
        long c = max(root.right);
        return Math.max(root.val, Math.max(b, c));
    }

    public long min(TreeNode root) {
        if (root == null)
            return Long.MAX_VALUE;
        long b = min(root.left);
        long c = min(root.right);
        if (c <= root.val)
            flag = false;
        return Math.min(root.val, Math.min(b, c));
    }

    public boolean isValidBST(TreeNode root) {
        flag = true;
        max(root);
        min(root);
        return flag;
    }
}
