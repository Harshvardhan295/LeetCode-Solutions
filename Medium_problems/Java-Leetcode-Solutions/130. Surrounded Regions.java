// DFS
class Solution {
    public void solve(char[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        boolean[][] vis = new boolean[m][n];

        // 1. DFS from first/last columns
        for (int i = 0; i < m; i++) {
            if (arr[i][0] == 'O' && vis[i][0] == false) {
                dfs(i, 0, arr, vis);
            }
            if (arr[i][n - 1] == 'O' && vis[i][n - 1] == false) {
                dfs(i, n - 1, arr, vis);
            }
        }
        // 2. DFS from first/last rows
        for (int j = 0; j < n; j++) {
            if (arr[0][j] == 'O' && vis[0][j] == false) {
                dfs(0, j, arr, vis);
            }
            if (arr[m - 1][j] == 'O' && vis[m - 1][j] == false) {
                dfs(m - 1, j, arr, vis);
            }
        }

        // 3. Flip surrounded 'O's
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Flip 'O' if it's not marked as visited (i.e., not connected to border)
                if (arr[i][j] == 'O' && vis[i][j] == false) {
                    arr[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(int i, int j, char[][] arr, boolean[][] vis) {
        int m = arr.length;
        int n = arr[0].length;

        // Base case: out of bounds, already visited, or 'X'
        if (i < 0 || j < 0 || i >= m || j >= n || vis[i][j] == true || arr[i][j] == 'X') {
            return;
        }

        vis[i][j] = true;

        // DFS in all 4 directions
        dfs(i + 1, j, arr, vis);
        dfs(i, j + 1, arr, vis);
        dfs(i - 1, j, arr, vis);
        dfs(i, j - 1, arr, vis);
    }
}

// BFS
class Solution {
    class Pair {
        int a, b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public void solve(char[][] arr) {
        int m = arr.length, n = arr[0].length;
        int[][] ans = new int[m][n];
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {// left border
            if (arr[i][0] == 'O') {
                arr[i][0] = '1';
                q.offer(new Pair(i, 0));
            }
        }
        for (int i = 0; i < n; i++) {// top border
            if (arr[0][i] == 'O') {
                arr[0][i] = '1';
                q.offer(new Pair(0, i));
            }
        }
        for (int i = 0; i < m; i++) {// right border
            if (arr[i][n - 1] == 'O') {
                arr[i][n - 1] = '1';
                q.offer(new Pair(i, n - 1));
            }
        }

        for (int i = 0; i < n; i++) {// bottom border
            if (arr[m - 1][i] == 'O') {
                arr[m - 1][i] = '1';
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
                        && arr[nx][ny] == 'O') {
                    arr[nx][ny] = '1';
                    q.offer(new Pair(nx, ny));
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == '1') {
                    arr[i][j] = 'O';
                } else {
                    arr[i][j] = 'X';
                }
            }
        }
        return;
    }
}
