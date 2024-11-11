struct ListNode* swapPairs(struct ListNode* head) {
    if (head == NULL || head->next == NULL) {
        return head;
    }

    struct ListNode* newHead = head->next; 
    struct ListNode* prev = NULL;
    struct ListNode* current = head;

    while (current != NULL && current->next != NULL) {
        struct ListNode* nextPair = current->next->next; 
        struct ListNode* second = current->next; 

        second->next = current;
        current->next = nextPair;

        if (prev != NULL) {
            prev->next = second;
        }

        prev = current;
        current = nextPair; 
    }

    return newHead;
}
