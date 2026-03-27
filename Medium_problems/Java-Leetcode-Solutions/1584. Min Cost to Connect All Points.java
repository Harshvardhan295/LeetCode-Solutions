class Solution {
    public class Triplet implements Comparable<Triplet> {
        int node;
        int parent;
        int dist;

        Triplet(int node, int parent, int dist) {
            this.node = node;
            this.parent = parent;
            this.dist = dist;
        }

        @Override
        public int compareTo(Triplet t) {
            if (this.dist == t.dist) {
                return Integer.compare(this.node, t.node);
            }
            return Integer.compare(this.dist, t.dist);
        }
    }

    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<Triplet> pq = new PriorityQueue<>();
        pq.add(new Triplet(0, -1, 0));
        int sum = 0;
        boolean[] visited = new boolean[points.length];
        while (!pq.isEmpty()) {
            Triplet front = pq.poll();
            int node = front.node;
            int parent = front.parent;
            int dist = front.dist;
            if (visited[node])
                continue;
            visited[node] = true;
            sum += dist;
            for (int i = 0; i < points.length; i++) {
                if(i==node || i== parent) continue;
                if (!visited[i]) {
                    int x1 = points[node][0], y1 = points[node][1];
                    int x2 = points[i][0], y2 = points[i][1];
                    int newDist = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                    pq.add(new Triplet(i, node, newDist));
                }
            }
        }
        return sum;
    }
}
