class Solution {
    public static void preorder(TreeNode root, List<TreeNode> arr) {
        if (root == null)
            return;
        arr.add(root);
        preorder(root.left,arr);
        preorder(root.right,arr);
    }
    public void flatten(TreeNode root) {
        if(root==null) return;
        if(root.left==null && root.right==null) return;
        List<TreeNode> arr = new ArrayList<>();
        preorder(root, arr);
        root=arr.get(0);
        for (int i = 0; i <arr.size() - 1; i++) {
            root.left=null;
            root.right=arr.get(i + 1);
            root=root.right;
        }    
        root.right=null;
        
    }
}
