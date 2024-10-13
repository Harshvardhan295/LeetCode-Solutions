//_________________________ LINKED LISTS ____________________________
class Solution {
    public ListNode reverseList(ListNode head) {
        // _____________Iterative Method______________
        ListNode current = head;
        ListNode prev = null;
        ListNode Next = head;
        while (current != null) {
            Next = current.next;
            current.next = prev;
            prev = current;
            current = Next;
        }
        return prev;
    }

    public boolean isPalindrome(ListNode head) {
        // if (head.next == null)
        //     return true;
        // ___________Deep Copy Method___________
        // ListNode newHead=new ListNode(head.val);
        // ListNode t1=head.next;
        // ListNode t2=newHead;
        // while(t1!=null){//creating deep copy
        // ListNode temp=new ListNode(t1.val);

        // t2.next=temp;
        // t2=t2.next;
        // t1=t1.next;
        // }
        // newHead=reverseList(newHead);//reversing deep copy
        // t1=head;
        // while(t1!=null){//comparing with the original lists
        // if(t1.val!=t2.val) return false;
        // t2=t2.next;
        // t1=t1.next;
        // }
        // return true;

        // __________Reversing the second half____________
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode j=reverseList(slow);
        ListNode i=head;
        while(j!=null){
            if(i.val!=j.val) return false;
            i=i.next;
            j=j.next;
        }
        return true;
    }
}
//_________________________ STACKS ____________________________
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
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        
        Stack<Integer> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }
        
        temp = head;
        while (temp != null) {
            if (temp.val != stack.pop()) {
                return false; 
            }
            temp = temp.next;
        }
        
        return true; // List is Palindrome
    }
}
