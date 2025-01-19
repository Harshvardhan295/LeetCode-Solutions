//Recursive Method
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;//base case: if it is leaf node
        list.addAll(inorderTraversal(root.left));
        list.add(root.val);
        list.addAll(inorderTraversal(root.right));
        return list;//return accumative result
    }
}
//Iterative Method
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        Stack<TreeNode> st=new Stack<>();
        TreeNode temp=root;
        while(true){
            if(temp!=null){
                st.push(temp);
                temp=temp.left;
            }
            else{
                if(st.isEmpty()) break;
                TreeNode top=st.pop();
                ans.add(top.val);
                temp=top.right;
            }
        }
        return ans;
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
