// Dijkstra + Heap
class Solution {
    public class Pair{
        int to;
        int cost;
        Pair(int to,int cost){
            this.to=to;
            this.cost=cost;
        }
    }
    public class Triplet implements Comparable<Triplet>{
        int to;
        int cost;
        int stops;
        Triplet(int to,int cost,int stops){
            this.to=to;
            this.cost=cost;
            this.stops=stops;
        }
        public int compareTo(Triplet t){
            // if cost same, sort on the basis of dst
            if(this.stops==t.stops) return this.cost-t.cost;
            return this.stops-t.stops;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<Pair>());
        for(int i=0;i<flights.length;i++){
            int from=flights[i][0], to =flights[i][1], cost=flights[i][2];
            adj.get(from).add(new Pair(to,cost));
        }

        //Dijkstra Algorithm
        int[] ans=new int[n+1];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[src]=0;
        PriorityQueue<Triplet> pq=new PriorityQueue<>();
        pq.add(new Triplet(src, 0,0));
        while(pq.size()>0){
            Triplet front=pq.remove();
            int to=front.to, cost=front.cost, stops=front.stops;
            if(stops ==k+1) continue;
            for(Pair p: adj.get(to)){
                int totalcost=cost+p.cost;
                if(totalcost < ans[p.to]){
                    ans[p.to]= totalcost;
                    pq.add(new Triplet(p.to, totalcost, stops+1));
                }
            }
        }
        if(ans[dst]==Integer.MAX_VALUE) return -1;
        return ans[dst];
    }
}
//Dijkstra + Queue method
class Solution {
    public class Pair{
        int to;
        int cost;
        Pair(int to,int cost){
            this.to=to;
            this.cost=cost;
        }
    }
    public class Triplet{
        int to;
        int cost;
        int stops;
        Triplet(int to,int cost,int stops){
            this.to=to;
            this.cost=cost;
            this.stops=stops;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<Pair>());
        for(int i=0;i<flights.length;i++){
            int from=flights[i][0], to =flights[i][1], cost=flights[i][2];
            adj.get(from).add(new Pair(to,cost));
        }

        //Dijkstra Algorithm
        int[] ans=new int[n+1];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[src]=0;
        Queue<Triplet> pq=new LinkedList<>();
        pq.add(new Triplet(src, 0,0));
        while(pq.size()>0){
            Triplet front=pq.remove();
            int to=front.to, cost=front.cost, stops=front.stops;
            if(stops ==k+1) continue;
            for(Pair p: adj.get(to)){
                int totalcost=cost+p.cost;
                if(totalcost < ans[p.to]){
                    ans[p.to]= totalcost;
                    pq.add(new Triplet(p.to, totalcost, stops+1));
                }
            }
        }
        if(ans[dst]==Integer.MAX_VALUE) return -1;
        return ans[dst];
    }
}
