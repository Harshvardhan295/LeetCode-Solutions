// BFS and DFS
import java.util.*;

class Solution {
    // red = 0, blue = 1
    public static boolean bfs(int i, int[][] g, int[] vis) {
        Queue<Integer> q = new LinkedList<>();
        vis[i] = 0;
        q.add(i);

        while (!q.isEmpty()) {
            int front = q.poll();
            int color = vis[front];

            for (int ele : g[front]) {
                if (vis[ele] == -1) {
                    vis[ele] = 1 - color;
                    q.add(ele);
                } else if (vis[ele] == color) {
                    return false; // found same color on both ends
                }
            }
        }
        return true;
    }

    public static boolean dfs(int i, int[][] g, int[] vis, int color) {
        vis[i] = color;
        for (int ele : g[i]) {
            if(vis[ele]==-1){
                if (!dfs(ele, g, vis, 1 - color)) return false;
            }
            else if (vis[ele] == color) {
                return false; // found same color on both ends
            }
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] vis = new int[n];
        Arrays.fill(vis, -1);
        for (int i = 0; i < n; i++) {
            if (vis[i] == -1) {
                // if (!bfs(i, graph, vis)) return false;
                if (!dfs(i, graph, vis, 1))
                    return false;
            }
        }
        return true;
    }
}

//Is Graph Bipartite using DSU
class Solution {
    
    static int[] parent,size;
    static boolean[] parity;
    public int find(int a){
        if(parent[a]==a) return a;
        return parent[a]=find(parent[a]);
    }

    public void union(int u, int v){
        int a=find(u);
        int b=find(v);
        if(a!=b){
            if(size[a]>size[b]){ // attach smaller set to bigger set
                parent[b]=a; //make a parent of b
                size[a]+=size[b]; //update size of bigger set
                parity[v]=!parity[u]; //update parity of smaller set

            } else{
                parent[a]=b; //make b parent of a
                size[b]+=size[a]; //update size of bigger set
                parity[u]=!parity[v]; //update parity of smaller set
            }
        }
    }

    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        parent=new int[n]; // 0 to n-1 nodes
        size=new int[n];
        parity=new boolean[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
            parity[i]=false; //initially all nodes are in same set and have same parity
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<graph[i].length;j++){

                int u=i, v=graph[i][j];
                if(find(u)==find(v)){
                    if(parity[u]==parity[v]) return false; //same set and same parity means odd cycle
                } else{
                    union(u,v);
                }
            }
        }
        return true;
    }
}
