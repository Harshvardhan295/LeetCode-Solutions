//max heap
import java.util.PriorityQueue;

class Solution {
    public int kthSmallest(int[][] a, int k) {
        int m = a.length;
        int n = a[0].length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());//max heap
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                pq.add(a[i][j]);
                if (pq.size() > k) {
                    pq.remove();
                }
            }
        }
        return pq.peek();
    }
}
//min heap
class Solution {
    public int kthSmallest(int[][] a, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int m = a.length;
        int n = a[0].length;
        // Min Heap
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                pq.add(a[i][j]);
            }
        }
        int i = 0;
        while (i < k - 1) {
            pq.remove();
            i++;
        }
        return pq.peek();
    }
}
