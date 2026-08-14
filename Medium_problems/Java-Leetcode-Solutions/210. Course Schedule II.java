// Topological Sort
class Solution {
    private void topologicalSortBFS(int vertices, List<List<Integer>> adj, int[] inDegree, List<Integer> ans) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < vertices; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);
            for (int ele : adj.get(node)) {
                inDegree[ele]--;
                if (inDegree[ele] == 0) {
                    q.add(ele);
                }
            }
        }
    }

    public int[] findOrder(int numCourses, int[][] pr) {

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) { 
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < pr.length; i++) {
            adj.get(pr[i][1]).add(pr[i][0]);
        }

        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int neighbor : adj.get(i)) {
                inDegree[neighbor]++;
            }
        }

        List<Integer> topoSort = new ArrayList<>();
        topologicalSortBFS(numCourses, adj, inDegree, topoSort);

        if (topoSort.size() != numCourses) return new int[0]; // cycle case

        return topoSort.stream().mapToInt(Integer::intValue).toArray();
    }
}
// Same method of Topological sort
class Solution {
    public int[] findOrder(int n, int[][] pr) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(new ArrayList<>());
        }
        for (int i = 0; i < pr.length; i++) {
            arr.get(pr[i][1]).add(pr[i][0]);
        }
        int[] indegree = new int[n];
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.get(i).size(); j++) {
                indegree[arr.get(i).get(j)]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) q.offer(i);
        }

        int[] ans = new int[n];
        int idx = 0;
        while (!q.isEmpty()) {
            int i = q.poll();
            ans[idx++] = i;

            for (int neigh : arr.get(i)) {
                indegree[neigh]--; 
                if (indegree[neigh] == 0) q.offer(neigh); 
            }
        }
        
        if (idx == n) return ans; // If all nodes are visited, return the order
        return new int[0]; // If there is a cycle, return an empty array
    }
}
