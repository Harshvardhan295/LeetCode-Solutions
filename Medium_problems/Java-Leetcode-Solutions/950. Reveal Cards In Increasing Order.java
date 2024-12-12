/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* deckRevealedIncreasing(int* deck, int n, int* returnSize) {
     qsort(deck, n, sizeof(int), compare);
     Queue<Integer> q=new LinkedList<>();
    int[] res=new int[n];
     for(int i=0;i<n;i++){
        q.add(i);
     }
     int i=0;
    while(!q.isEmpty()){
        res[q.poll()]=deck[i++];
        q.add(q.poll());
    }
    return res;
}
