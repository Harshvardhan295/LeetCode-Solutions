class Solution {
    static int sum=0;
    public static void reverseInorder(TreeNode root) {
        if (root == null)
            return;
        reverseInorder(root.right);
        root.val+=sum;
        sum=root.val;
        reverseInorder(root.left);
    }

    public TreeNode bstToGst(TreeNode root) {
        sum = 0;
        reverseInorder(root);
        return root;
    }
}
//Morris Traversal
class Solution {
    public boolean isValidBST(TreeNode root) {
        TreeNode prev=null;
        TreeNode curr=root;
        while(curr!=null){
            if(curr.left!=null) { // going in left subtree
                TreeNode pred=curr.left; 
                while(pred.right!=null && pred.right!=curr){
                    pred=pred.right;
                }
                if(pred.right==null){ //link
                    pred.right=curr;
                    curr=curr.left;
                }
                else{ //unlink
                    pred.right=null;
                    if(prev!=null && prev.val>=curr.val) return false;
                    prev=curr;
                    curr=curr.right;
                }
            }
                else{ // going in right subtree
                    if(prev!=null && prev.val>=curr.val) return false;
                    prev=curr;
                    curr=curr.right;
            }
        }
        return true;
    }
}
