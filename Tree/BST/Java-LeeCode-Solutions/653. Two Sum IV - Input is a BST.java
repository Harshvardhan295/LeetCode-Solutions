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
    public List<Integer> helper(TreeNode root, int k,List<Integer> l) {
        if (root == null) return l;
        l.add(root.val);
        helper(root.left,k,l);
        helper(root.right,k,l);
        return l;
    }
    public boolean twoSum(List<Integer> nums, int target) {
        HashSet<Integer> m1=new HashSet<>();
        for(int i=0;i< nums.size();i++){
            int rem=target-nums.get(i);
            if(m1.contains(rem)){
                return true;
            }
            else m1.add(nums.get(i));
        }
        return false;
    }
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> ans= helper(root, k,new ArrayList<>());
        return twoSum(ans,k);
    }
}
