//min heap
class Solution {
    public int findKthLargest(int[] a, int k) {
        int n = a.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int j = 0; j < n; j++) {
            pq.add(a[j]);
            if (pq.size() > k) {
                pq.remove();
            }
        }
        return pq.peek();
    }
}
//max heap
class Solution {
    public int findKthLargest(int[] a, int k) {
        int n = a.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // Max Heap
        for (int j = 0; j < n; j++) {
            pq.add(a[j]);
        }
        int i = 0;
        while (i < k - 1) {
            pq.remove();
            i++;
        }
        return pq.peek();
    }
}
