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
    public void helper(TreeNode root, List<Integer> flat) {
        if (root == null) return;
        helper(root.left, flat);
        flat.add(root.val);
        helper(root.right, flat);
    }

    public List<Integer> binarySearch(List<Integer> arr, int t) {
        int i = 0, j = arr.size() - 1; 
        int floor = -1, ceiling = -1;

        while (i <= j) { 
            int mid = i + (j - i) / 2;

            if (arr.get(mid) == t) {
                floor = arr.get(mid);
                ceiling = arr.get(mid);
                break;
            } else if (arr.get(mid) > t) {
                ceiling = arr.get(mid); 
                j = mid - 1;
            } else {
                floor = arr.get(mid);   
                i = mid + 1;
            }
        }
        return Arrays.asList(floor, ceiling);
    }

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> q) {
        List<Integer> flat = new ArrayList<>();
        helper(root, flat); 
        
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < q.size(); i++) {
            ans.add(binarySearch(flat, q.get(i)));
        }
        return ans;
    }
}
