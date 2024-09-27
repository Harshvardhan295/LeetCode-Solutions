import java.util.ArrayList;

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 == null) {
            temp.next = temp2;
        } else {
            temp.next = temp1;
        }
        return dummy.next;
    }

    public ListNode mergeKLists(ListNode[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        ListNode mergedList = arr[0];//stored the first linkedlist of lists(array) 
        for (int i = 1; i < arr.length; i++) { //iterating from the second linkedlist of lists(array)
            mergedList = mergeTwoLists(mergedList, arr[i]);
            //merging the first and second linkedlist in order and stored it and same for the further linkedlist in array lists
        }
        return mergedList;
    }
}

