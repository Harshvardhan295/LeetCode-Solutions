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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode left=head;
        ListNode mid=head.next;
        ListNode right=head.next.next;
        int idx=1;
        int first=-1,last=-1;
        int minDistance=Integer.MAX_VALUE;
        int[] arr={-1,-1};
        while(right!=null){
            if(mid.val>left.val&&mid.val>right.val || mid.val<left.val&&mid.val<right.val){
                if(first==-1) first=idx;
                if(last!=-1){
                    int distance=idx-last;
                    minDistance=Math.min(minDistance,distance);
                }
                last=idx;
            }
            idx++;
            left=left.next;
            mid=mid.next;
            right=right.next;
        }
        if(first==last) return arr;
        int maxDistance=last-first;
        arr[0]=minDistance;
        arr[1]=maxDistance;
    return arr;
    }
}
