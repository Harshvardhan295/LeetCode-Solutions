//BFS
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
// DSU krushkal
class Solution {
    //Optimised krushkal
    static int[] parent, size;
    public int find(int a){
        if(parent[a]==a) return a;
        return parent[a]=find(parent[a]);
    }
    public void union(int a, int b){
        a=find(a);
        b=find(b);
        if(a!=b){
            if(size[a]>size[b]){ // attach smaller set to bigger set
                parent[b]=a; //make a parent of b
                size[a]+=size[b]; //update size of bigger set
            } else{
                parent[a]=b; //make b parent of a
                size[b]+=size[a]; //update size of bigger set
            }
        }
    }

    class Edge implements Comparable<Edge>{
        int u, v, w;
        Edge(int u, int v, int w){
            this.u=u;
            this.v=v;
            this.w=w;
        }
        public int compareTo(Edge e){
            return Integer.compare(this.w, e.w);
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int n=points.length,minCost=0;
        parent=new int[n+1]; // 1 to n nodes
        size=new int[n+1];
        for(int i=1;i<=n;i++){
            parent[i]=i;
            size[i]=1;
        }
        //u , v , weight
        List<Edge> edgelist=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int x = Math.abs(points[i][0]-points[j][0]);
                int y = Math.abs(points[i][1]-points[j][1]);
                int w= x + y;
                edgelist.add( new Edge(i,j,w));
            }
        }
        Collections.sort(edgelist); // sort based on weight
        for(Edge edge: edgelist){
            int u=edge.u, v=edge.v, w=edge.w;
            if(find(u)!=find(v)){
                union(u,v);
                minCost+=w;
            }
        }
        return minCost;
    }
}
