// Linked List Solution
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);

        // Use slow/fast pointers to find the middle
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // 'slow' is now the middle. Disconnect the left half.
        if (prev != null) prev.next = null;

        TreeNode root = new TreeNode(slow.val);
        
        // Recursively build left and right subtrees
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);

        return root;
    }
}

// DFS
class Solution {
    public TreeNode buildBST(List<Integer> list, int left, int right) {
        if (left > right) return null;

        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(list.get(mid));

        node.left = buildBST(list, left, mid - 1);
        node.right = buildBST(list, mid + 1, right);

        return node;
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null; 
        // Convert Linked List to ArrayList for fast O(1) index access
        List<Integer> list = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }

        return buildBST(list, 0, list.size() - 1);
    }
}
