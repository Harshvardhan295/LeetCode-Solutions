//Code using shallow copy
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

