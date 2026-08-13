class Solution {
    static int edge=0, node = 0;

    public void dfs(ArrayList<ArrayList<Integer>> adj,boolean[] vis,int curr){
        vis[curr]=true;
        node++;
        for(int neighbor:adj.get(curr)){
            edge++;
            if (!vis[neighbor]) {
                dfs(adj, vis, neighbor);

            }
        }
    }

    public int countCompleteComponents(int n, int[][] arr) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<arr.length;i++){
            int u=arr[i][0];
            int v=arr[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] vis=new boolean[n];
        int comp=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(adj,vis,i);
                edge/=2;
                if(((node*(node-1))/2)==edge) comp++;
            }
            node=0;
            edge=0;
        }

        return comp;
    }
}
