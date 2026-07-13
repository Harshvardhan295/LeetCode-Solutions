// BFS
class Solution {
        class Pair {
        int a, b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
    public int numEnclaves(int[][] arr) {
        int m = arr.length, n = arr[0].length;
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {// left border
            if (arr[i][0] == 1) {
                arr[i][0] = 2;
                q.offer(new Pair(i, 0));
            }
        }
        for (int i = 0; i < n; i++) {// top border
            if (arr[0][i] == 1) {
                arr[0][i] = 2;
                q.offer(new Pair(0, i));
            }
        }
        for (int i = 0; i < m; i++) {// right border
            if (arr[i][n - 1] == 1) {
                arr[i][n - 1] = 2;
                q.offer(new Pair(i, n - 1));
            }
        }

        for (int i = 0; i < n; i++) {// bottom border
            if (arr[m - 1][i] == 1) {
                arr[m - 1][i] = 2;
                q.offer(new Pair(m - 1, i));
            }
        }

        int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int x = curr.a;
            int y = curr.b;

            for (int[] d : dir) {
                int nx = x + d[0];
                int ny = y + d[1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n
                        && arr[nx][ny] == 1) {
                    arr[nx][ny] = 2;
                    q.offer(new Pair(nx, ny));
                }
            }
        }
        int ans=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
