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

