class Solution {
    class ListNode {
        long val;
        ListNode next;
        ListNode prev;

        ListNode(long val) {
            this.val = val;
        }
    }

    public List<Long> mergeAdjacent(int[] nums) {
        ListNode head = new ListNode(nums[0]);
        ListNode curr = head;

        for (int i = 1; i < nums.length; i++) {
            ListNode node = new ListNode(nums[i]);
            curr.next = node;
            node.prev = curr;
            curr = node;
        }
        curr = head;
        while (curr != null && curr.next != null) {

            if (curr.val == curr.next.val) {
                curr.val += curr.next.val;
                ListNode toDelete = curr.next;
                curr.next = toDelete.next;

                if (toDelete.next != null) {
                    toDelete.next.prev = curr;
                }

                if (curr.prev != null) {
                    curr = curr.prev;
                }
            } else {
                curr = curr.next;
            }
        }

        List<Long> result = new ArrayList<>();
        curr = head;
        while (curr != null) {
            result.add(curr.val);
            curr = curr.next;
        }

        return result;
    }
}
