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
    public long kthLargestLevelSum(TreeNode root, int k) {
        List<Long> levelSums = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            long sum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                sum += node.val;

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            levelSums.add(sum);
        }

        if (k > levelSums.size()) return -1;//k is greater than number of levels

        levelSums.sort(Collections.reverseOrder());
        return levelSums.get(k - 1);
    }
}
// optimised method
class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> q=new LinkedList<>();
        Queue<Long> pq=new PriorityQueue<>();
        q.offer(root);
        
        while(q.size()>0){
            int size=q.size();
            long sum=0l;
            for(int i=0; i<size; i++){
                TreeNode node=q.poll();
                sum+=node.val;
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
            }
            pq.add(sum);
            if(pq.size()>k){
                pq.poll();
            }
        }
        if(pq.size()<k) return -1;
        return pq.peek();
    }
}
