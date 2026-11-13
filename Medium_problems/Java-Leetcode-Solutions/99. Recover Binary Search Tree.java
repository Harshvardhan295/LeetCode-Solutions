//Morris Traversal
class Solution {
    public void recoverTree(TreeNode root) {
        TreeNode first = null;
        TreeNode second = null;
        TreeNode prev = null;

        TreeNode curr = root;

        while (curr != null) {
            if (curr.left != null) { // going in left subtree
                TreeNode pred = curr.left;
                while (pred.right != null && pred.right != curr) {
                    pred = pred.right;
                }
                if (pred.right == null) { //link
                    pred.right = curr;
                    curr = curr.left;
                } else { //unlink
                    pred.right = null;
                    // Process the current node
                    // the only change in morris traversal
                    if (prev != null && prev.val > curr.val) {
                        if (first == null) first = prev;
                        second = curr;
                    }
                    prev = curr;
                    curr = curr.right;
                }
            } else { // going in right subtree
                // Process the current node
                // the only change in morris traversal
                if (prev != null && prev.val > curr.val) {
                    if (first == null) first = prev;
                    second = curr;
                }
                prev = curr;
                curr = curr.right;
            }
        }

        // Swap values of the two misplaced nodes
        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }
}
