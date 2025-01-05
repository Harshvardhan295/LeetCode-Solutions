//Optimised Code
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> list = new ArrayList();
        List<List<Integer>> ans = new ArrayList();
        helper(root, targetSum, list, ans);
        return ans;
    }

    private static void helper(TreeNode root, int sum, List<Integer> list, List<List<Integer>> ans) {
        if (root == null) return;
        list.add(root.val);
        if (root.val == sum && root.left == null && root.right == null)
            ans.add(new ArrayList<Integer>(list));
        else {
            helper(root.left, sum - root.val, list, ans);
            helper(root.right, sum - root.val, list, ans);
        }
        // remove the current node from the path to backtrack, 
        // we need to remove the current node while we are going up the recursive call stack.
        list.remove(list.size() - 1);
    }
}
//slower method
class Solution {
    public static List<Integer> copy(List<Integer> arr) {
        List<Integer> list = new ArrayList<>();
        for (int ele : arr) {
            list.add(ele);
        }
        return list;
    }

    public static void helper(TreeNode root, int sum, List<Integer> arr, List<List<Integer>> ans) {
        if (root == null)
            return;
        if (root.left == null && root.right == null){
            if(root.val == sum){
            arr.add(root.val);
            ans.add(arr);
            }
            return;
    }
        arr.add(root.val);
        List<Integer> arr1 = copy(arr);
        List<Integer> arr2 = copy(arr);
        helper(root.left, sum - root.val,arr1, ans);
        helper(root.right, sum - root.val,arr2, ans);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> list = new ArrayList();
        List<List<Integer>> ans = new ArrayList();
        helper(root, targetSum, list, ans);
        return ans;
    }
}
