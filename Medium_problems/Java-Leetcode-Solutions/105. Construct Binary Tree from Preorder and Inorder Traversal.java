class Solution {
    public TreeNode helper(int[] preorder, int[] inorder, int plo, int phi, int inlo, int inhi) {
        
        if (plo > phi || inlo > inhi) return null;
        //preorder traversal's first node is the root node
        TreeNode root = new TreeNode(preorder[plo]);
        
        int idx = 0; //finding root node in inorder traversal
        while (inorder[idx] != preorder[plo]) idx++;
        int leftSize = idx - inlo; // Calculate the size of the left subtree
        root.left = helper(preorder, inorder, plo + 1, plo + leftSize, inlo, idx - 1);
        root.right = helper(preorder, inorder, plo + leftSize + 1, phi, idx + 1, inhi);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length; 
        return helper(preorder, inorder, 0, n - 1, 0, n - 1);
    }
}
