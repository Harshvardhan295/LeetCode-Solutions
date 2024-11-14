/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* reverseList(struct ListNode* head) {
    //--------------iterative--------------
        // struct ListNode* current=head;
        // struct ListNode* prev=NULL;
        // struct ListNode* Next=head;
        // while(current!=NULL){
        // Next=current->next;
        // current->next=prev;
        // prev=current;
        // current=Next;
        // }
        // return prev;

//-----------recursive------------
if (head == NULL || head->next == NULL)
            return head;
        struct ListNode* a = head->next;
        struct ListNode* newHead = reverseList(a);
        a->next = head;
        head->next = NULL;
        return newHead;
}
