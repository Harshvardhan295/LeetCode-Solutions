class Solution {

    public class Triplet implements Comparable<Triplet> {
        int row;
        int col;
        int safeness;

        Triplet(int row, int col, int safeness) {
            this.row = row;
            this.col = col;
            this.safeness = safeness;
        }

        // MAX heap based on safeness
        @Override
        public int compareTo(Triplet t) {
            return Integer.compare(t.safeness, this.safeness);
        }
    }

    public int maximumSafenessFactor(List<List<Integer>> grid) {

        int n = grid.size();
        int[][] ans = new int[n][n];

        // Distance from nearest thief (Multi-source BFS)
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    ans[i][j] = 0;
                    q.add(new int[]{i, j});
                } else {
                    ans[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[] r = {-1, 0, 1, 0};
        int[] c = {0, -1, 0, 1};

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int row = cur[0];
            int col = cur[1];

            for (int k = 0; k < 4; k++) {
                int newRow = row + r[k];
                int newCol = col + c[k];

                if (newRow >= 0 && newCol >= 0 && newRow < n && newCol < n &&
                        ans[newRow][newCol] > ans[row][col] + 1) {
                    ans[newRow][newCol] = ans[row][col] + 1; //+1 implements the manhattan distance here
                    q.add(new int[]{newRow, newCol});
                }
            }
        }

        // Dijkstra using Max Heap
        PriorityQueue<Triplet> pq = new PriorityQueue<>();
        boolean[][] visited = new boolean[n][n];

        pq.add(new Triplet(0, 0, ans[0][0]));

        while (!pq.isEmpty()) {
            Triplet top = pq.poll();
            int row = top.row;
            int col = top.col;
            int safeness = top.safeness;

            if (visited[row][col]) continue;
            visited[row][col] = true;

            if (row == n - 1 && col == n - 1)
                return safeness;

            for (int k = 0; k < 4; k++) {
                int newRow = row + r[k];
                int newCol = col + c[k];

                if (newRow >= 0 && newCol >= 0 && newRow < n && newCol < n &&
                        !visited[newRow][newCol]) {

                    int newSafeness = Math.min(safeness, ans[newRow][newCol]);
                    pq.add(new Triplet(newRow, newCol, newSafeness));
                }
            }
        }

        return 0;
    }
}
