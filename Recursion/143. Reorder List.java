/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public ListNode MiddleFind(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        ListNode Next;
        while (current != null) {
            Next = current.next;
            current.next = prev;
            prev = current;
            current = Next;
        }
        return prev;
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode middle = MiddleFind(head);
        ListNode temp2 = middle.next;
        middle.next = null;

        temp2 = reverseList(temp2);

        ListNode temp = head;
        ListNode dummy = new ListNode(-1);
        ListNode result = dummy;

        while (temp != null && temp2 != null) {
            result.next = temp;
            temp = temp.next;
            result = result.next;

            result.next = temp2;
            temp2 = temp2.next;
            result = result.next;
        }

        if (temp != null) {
            result.next = temp;
        }

        if (temp2 != null) {
            result.next = temp2;
        }

        head = dummy.next;
    }
}

