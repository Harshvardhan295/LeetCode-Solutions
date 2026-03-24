class Solution {
    public static void bfs(int i,int[][] adj,boolean[] vis){
        Queue<Integer> q=new LinkedList<>();
        q.add(i);
        while(q.size()>0){
            int front=q.remove();
            for(int j=0;j<adj.length;j++){
                if(adj[front][j]==1 && !vis[j]){
                    q.add(j);
                    vis[j]=true;
                }
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        boolean[] vis=new boolean[isConnected.length];
        int count=0;
        for(int i=0;i<isConnected.length;i++){
            if(!vis[i]){
                bfs(i,isConnected,vis);
                count++;
                vis[i]=true;

            }
        }
        return count;
    }
}
