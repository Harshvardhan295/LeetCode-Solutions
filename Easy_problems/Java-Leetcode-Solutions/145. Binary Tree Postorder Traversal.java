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
