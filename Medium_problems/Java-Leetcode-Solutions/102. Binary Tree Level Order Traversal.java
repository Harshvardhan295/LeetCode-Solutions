//Method 1
class Solution {
    public int levels(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(levels(root.left), levels(root.right));
    }

    public void nthLevel(TreeNode root, int level, int n, List<Integer> arr) {
        if (root == null)
            return;

        if (level == n) {
            arr.add(root.val);
            return;
        }

        nthLevel(root.left, level + 1, n, arr);
        nthLevel(root.right, level + 1, n, arr);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
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
//Method 2
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> l = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if (root != null) q.add(root);
        
        while (!q.isEmpty()) { 
            int levelSize = q.size(); 
            List<Integer> list = new ArrayList<>(); 
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode front = q.remove();
                list.add(front.val);
                
                if (front.left != null) q.add(front.left);
                if (front.right != null) q.add(front.right);
            }
            l.add(list); 
        }
        return l;
    }
}
//Method using pair class
class Solution {
    public class Pair {
        TreeNode node;
        int level;

        Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
    public int levels(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(levels(root.left), levels(root.right));
    }
    public void BFS(TreeNode root, List<List<Integer>> result) {
        Queue<Pair> q = new LinkedList<>();
        if (root != null) q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair front = q.remove();
            TreeNode temp = front.node;
            int level = front.level;

            result.get(level).add(temp.val);

            if (temp.left != null) q.add(new Pair(temp.left, level + 1));
            if (temp.right != null) q.add(new Pair(temp.right, level + 1));
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        int n = levels(root);

        for (int i = 0; i < n; i++) {
            result.add(new ArrayList<>());
        }

        BFS(root, result);
        return result;
    }
}
