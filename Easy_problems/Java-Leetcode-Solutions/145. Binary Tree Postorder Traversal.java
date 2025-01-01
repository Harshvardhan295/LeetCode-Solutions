//Recursive Method 
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;//base case: if it is leaf node
        list.addAll(postorderTraversal(root.left));
        list.addAll(postorderTraversal(root.right));
        list.add(root.val);
        return list;//return accumative result
    }
}
//Iterative Method
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        if (root != null)
            st.push(root);
        while (!st.isEmpty()) {
            TreeNode top = st.pop();
            ans.add(top.val);
            if (top.left != null)
                st.push(top.left);
            if (top.right != null)
                st.push(top.right); 
        }
        Collections.reverse(ans);
        return ans;
    }
}
