class Solution {
    public class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int[][] kClosest(int[][] a, int k) {
        int m = a.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> {
            int dist1 = p1.x * p1.x + p1.y * p1.y;
            int dist2 = p2.x * p2.x + p2.y * p2.y;
            return dist2 - dist1;
        });

        for (int i = 0; i < m; i++) {
            int x = a[i][0];
            int y = a[i][1];
            Pair point = new Pair(x, y);
            pq.add(point);
            if (pq.size() > k) pq.poll();
        }

        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) {
            Pair point = pq.poll();
            ans[i][0] = point.x;
            ans[i][1] = point.y;
        }

        return ans;
    }
}
