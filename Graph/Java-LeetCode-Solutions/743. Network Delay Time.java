class Solution {
    public class Pair //implements Comparable<Pair>
    {
        int node;
        int distance;
        Pair(int node, int distance){
            this.node =node;
            this.distance=distance;
        }
        // public int compareTo(Pair p){
        //     if(this.distance==p.distance) return this.node-p.node;
        //     return this.distance-p.distance;
        // }
    }

    public int networkDelayTime(int[][] times, int n, int src) {
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<Pair>());
        for(int[] time:times){
            int u=time[0], v=time[1], weight=time[2];
            adj.get(u).add(new Pair(v, weight));
        }
        //Dijkstra Algorithm
        int[] ans=new int[n+1];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[src]=0;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a, b)-> a.distance - b.distance);
        pq.add(new Pair(src, 0));
        while(pq.size()>0){
            Pair front=pq.poll();
            int node=front.node;
            int dist=front.distance;
            if(dist> ans[node]) continue;
            for(Pair neighbor: adj.get(node)){
                int totaldist=dist+neighbor.distance;
                if(totaldist < ans[neighbor.node]){
                    ans[neighbor.node]= totaldist;
                    pq.add(new Pair(neighbor.node, ans[neighbor.node]));
                }
            }
        }
        int maxDelay=-1;
        for(int i=1;i<=n;i++){
            if(ans[i]==Integer.MAX_VALUE) return -1;
            maxDelay=Math.max(maxDelay, ans[i]);
        }
        return maxDelay;
    }
}
