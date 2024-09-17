class Solution {
    ListNode getKthNode(ListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(0); 
        dummy.next = head;
        ListNode groupPrev = dummy;

        while (true) {
            
            ListNode kthNode = getKthNode(groupPrev, k);
            if (kthNode == null)
                break; // If we don't have k nodes, we're done

            ListNode groupNext = kthNode.next; 
            ListNode prev = kthNode.next; 
            ListNode curr = groupPrev.next; 

            // Reverse the k nodes
            while (curr != groupNext) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            ListNode temp = groupPrev.next; 
            groupPrev.next = kthNode; 
            groupPrev = temp; 
        }

        return dummy.next;
    }
}

