class Solution {
    // DSU 
    static int[] parent;
    static int[] size;
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

    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        parent=new int[n+1]; // 1 to n nodes
        size=new int[n+1];
        for(int i=1;i<=n;i++){
            parent[i]=i;
            size[i]=1;
        }
        int[] ans=new int[2];
        for(int[] edge: edges){
            int u=edge[0], v=edge[1];
            if(find(u)==find(v)) {
                ans[0]=u;
                ans[1]=v;
                break; //edge creating cycle
            }
            else union(u,v);
        }
        return ans;
    }
}
