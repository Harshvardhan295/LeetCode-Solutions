//Method 1
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> l = new ArrayList<>();
        if (root == null) return l;

        Deque<TreeNode> q = new LinkedList<>();
        q.add(root);
        int levelnumber = 0;

        while (!q.isEmpty()) { 
            int levelSize = q.size(); 
            List<Integer> list = new ArrayList<>(); 

            for (int i = 0; i < levelSize; i++) {
                if (levelnumber % 2 == 0) {
                    TreeNode front = q.pollFirst();
                    list.add(front.val);
                    if (front.left != null) q.addLast(front.left);
                    if (front.right != null) q.addLast(front.right);
                } else {
                    TreeNode front = q.pollLast();
                    list.add(front.val);
                    if (front.right != null) q.addFirst(front.right);
                    if (front.left != null) q.addFirst(front.left);
                }
            }
            l.add(list); 
            levelnumber++;
        }
        return l;
    }
}
//Method 2
class Solution {

    public int levels(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(levels(root.left), levels(root.right));
    }

    public void nthLevel(TreeNode root, int level, int n, List<Integer> arr) {
        if (root == null)
            return;

        if (n % 2 == 0) {
            if (level == n) {
                arr.add(root.val);
                return;
            }
            nthLevel(root.left, level + 1, n, arr);
            nthLevel(root.right, level + 1, n, arr);
        } else {
            if (level == n) {
                arr.add(root.val);
                return;
            }
            nthLevel(root.right, level + 1, n, arr);
            nthLevel(root.left, level + 1, n, arr);
        }

    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();
        int n = levels(root); // Total number of levels

        // Traverse through all levels
        for (int i = 0; i < n; i++) {
            List<Integer> arr = new ArrayList<>();
            nthLevel(root, 0, i, arr);
            ans.add(arr);
        }
        return ans;
    }
}

