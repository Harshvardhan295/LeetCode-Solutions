//Method 1 - Optimal Solution
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        int lh=findHeightLeft(root);
        int rh=findHeightRight(root);
        if(lh==rh){
            return (1<<lh)-1;// left shift -1 gives n nodes
        }
        return 1+countNodes(root.left)+countNodes(root.right);

    }
    public int findHeightLeft(TreeNode root){
        int height=0;
        while(root!=null){
            height++;
            root=root.left;
        }
        return height;
    }
    public int findHeightRight(TreeNode root){
      int height=0;
      while(root!=null){
        height++;
        root=root.right;
      }
      return height;
    }
}

// Method 2
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int helper(TreeNode root,int ans){
        if(root==null) return 0;
        if(root.left!=null) ans=helper(root.left,ans+1);
        System.out.println(ans);
        if(root.right!=null) ans=helper(root.right,ans+1);
        return ans;
    }
    public int countNodes(TreeNode root) {
        int ans=helper(root,1);
        return ans;
    }
}
