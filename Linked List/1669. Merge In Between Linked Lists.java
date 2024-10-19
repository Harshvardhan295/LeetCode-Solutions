/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode beforeA = list1;
        ListNode front = null;
        if(a > 0){
            front = getNodeAtPosition(beforeA, a - 1);
        }

        ListNode afterB = getNodeAtPosition(beforeA, b + 1);

        ListNode nodeAfterCurrent = list2;
        ListNode list2Head = list2;
        while(nodeAfterCurrent.next != null){
            nodeAfterCurrent = nodeAfterCurrent.next;
        }

        front.next = list2Head;
        nodeAfterCurrent.next = afterB;
        
        return list1;
    }

    private static ListNode getNodeAtPosition(ListNode head, int position ){
        ListNode current = head;
        int count = 0;
        while(current != null && count < position){
            current = current.next;
            count++;
        }
        return current;
    }

}
