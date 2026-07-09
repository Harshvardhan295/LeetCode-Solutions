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
    public List<Integer> inorder(TreeNode root) {
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
  
    public int findSecondMinimumValue(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        ans =inorder(root);
        System.out.println(ans);
        Collections.sort(ans);
        System.out.println(ans);
        for(int i=0;i<ans.size()-1;i++){
            if(ans.get(i)<ans.get(i+1)) return ans.get(i+1);
        }
        return -1;
    }
}
