class Solution {
    public int[] sortArray(int[] a) {
        int n = a.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();//min heap
        for (int j = 0; j < n; j++) {
            pq.add(a[j]);
        }
        int i = 0;
        while (i < n) {
            a[i++]=pq.remove();
        }
        return a;
    }
}
