//Method 1: using arraylist
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
//Method 2 : recursive
class Solution {
    public void flatten(TreeNode root) {
        if(root==null) return;
        if(root.left==null && root.right==null) return;
        TreeNode lst=root.left;
        TreeNode rst=root.right;
        flatten(lst);
        flatten(rst);
        root.left=null;
        root.right=lst;
        TreeNode temp=root;
        while(temp.right!=null) temp=temp.right;
        temp.right=rst;
    }
}
// Method 3 : Morris Traversal
class Solution {
    public void flatten(TreeNode root) {
        TreeNode curr=root;
        while(curr!=null){
            if(curr.left!=null){
                TreeNode r=curr.right;
                curr.right=curr.left;
                TreeNode pred=curr.left;
                while(pred.right!=null) pred=pred.right;
                pred.right=r;
                curr.left=null;//Important
                curr=curr.right;
            }
            else{
                curr=curr.right;
            }
        }
    }
}
