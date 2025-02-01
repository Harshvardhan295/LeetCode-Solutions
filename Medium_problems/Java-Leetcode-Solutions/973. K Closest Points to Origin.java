//method 1
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
//method 2
class Solution {
    public class Triplet implements Comparable<Triplet>{
        int x, y,d;
        Triplet(int d,int x, int y) {
            this.x = x;
            this.y = y;
            this.d=d;
        }
        public int compareTo(Triplet t){
            return this.d-t.d;
        }
    }

    public int[][] kClosest(int[][] a, int k) {
        int m = a.length;
        PriorityQueue<Triplet> pq = new PriorityQueue<>(Collections.reverseOrder()); // max heap
        for (int i = 0; i < m; i++) {
            int x=a[i][0],y=a[i][1];
            int d = x*x+y*y; // distance formula from origin
            pq.add(new Triplet(d,x,y));
            if (pq.size() > k) pq.remove();// removing greater distance

        }

        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) {
            // req. closest distance
            Triplet t = pq.remove();
            ans[i][0] = t.x;
            ans[i][1] = t.y;
        }
        return ans;
    }
}
