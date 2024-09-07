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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode dummyOdd = new ListNode(-1);
        ListNode dummyEven = new ListNode(-1);
        ListNode odd = dummyOdd, even = dummyEven;
        ListNode current = head;
        int index = 1;

        // Separate the list into odd and even based on index
        while (current != null) {
            if (index % 2 != 0) {
                odd.next = current;
                odd = odd.next;
            } else {
                even.next = current;
                even = even.next;
            }
            current = current.next;
            index++;
        }

        odd.next = null;
        even.next = null;

        odd = dummyOdd.next;
        even = dummyEven.next;

        ListNode temp = new ListNode(-1);
        ListNode result = temp;
        index = 1;

        while (odd != null || even != null) {
            if (index % 2 != 0 && even != null) {
                temp.next = even;
                even = even.next;
            } else if (odd != null) {
                temp.next = odd;
                odd = odd.next;
            }
            temp = temp.next;
            index++;
        }

        return result.next; // Skip the initial dummy node
    }
}

