class Solution {
    static final long MOD = 1_000_000_007L;

    public long power(long base, long exp, long mod) {
        if (exp < 0) return 0; // Handle edge case if maxDepth was 0
        long res = 1;
        base = base % mod;
        while (exp > 0) {
            if (exp % 2 == 1) res = (res * base) % mod;
            base = (base * base) % mod;
            exp /= 2;
        }
        return res;
    }

    public int getMaxDepth(List<List<Integer>> adj, int node, int parent) {
        int depth = 0;
        for (int neighbor : adj.get(node)) {
            if (neighbor == parent) continue;
            depth = Math.max(depth, getMaxDepth(adj, neighbor, node) + 1);
        }

        return depth;
    }

    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1; // total nodes
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) { 
            adj.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        int maxDepth = getMaxDepth(adj, 1, 0);
        return (int) power(2, maxDepth - 1, MOD);
    }
}
