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
    class Pair {
        TreeNode node;
        int idx;
        Pair(TreeNode node, int idx){
            this.node = node;
            this.idx = idx;
        }
    }
    
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));
        int max = 0;
        while(!q.isEmpty())
        {
            int size = q.size();
            int start = 0, end = 0;
            for(int i=0; i<size; i++)
            {
                Pair front = q.remove();
                int index = front.idx; 
                if(i==0) 
                    start = index; //start and end index for each level
                
                if(i==size-1) 
                    end = index;
                
                if(front.node.left!=null)
                    q.add(new Pair(front.node.left, 2*front.idx+1));

                if(front.node.right!=null)
                    q.add(new Pair(front.node.right, 2*front.idx+2));
                
            }
            max = Math.max(max, end - start + 1);
        }
        return max;    
    }
}
