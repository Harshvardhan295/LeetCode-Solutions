// BFS
class Solution {
    public int orangesRotting(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        int freshCount = 0;
        
        // Find ALL rotten oranges and count all fresh oranges
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 2) {
                    q.offer(new int[] { i, j });
                } else if (arr[i][j] == 1) {
                    freshCount++;
                }
            }
        }
        
        // If there are no fresh oranges to begin with, 0 minutes are needed
        if (freshCount == 0) return 0;
        
        int minutes = 0;
        // Direction arrays to easily traverse Left, Right, Up, Down
        int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        
        // Process BFS level by level (minute by minute)
        while (!q.isEmpty() && freshCount > 0) {
            int size = q.size();
            minutes++;
            
            // Process all oranges that became rotten at the exact same minute
            for (int k = 0; k < size; k++) {
                int[] a = q.poll();
                int i = a[0];
                int j = a[1];
                
                for (int[] dir : directions) {
                    int ni = i + dir[0];
                    int nj = j + dir[1];
                    
                    // Check bounds and ensure we ONLY target fresh oranges (1)
                    if (ni >= 0 && ni < m && nj >= 0 && nj < n && arr[ni][nj] == 1) {
                        arr[ni][nj] = 2; // Rot the fresh orange
                        freshCount--;    // Decrement the fresh counter
                        q.offer(new int[] { ni, nj });
                    }
                }
            }
        }
        
        //If fresh oranges still remain, return -1, otherwise return minutes
        return freshCount == 0 ? minutes : -1;
    }
}
// Method 2
class Solution {
    public int orangesRotting(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int ans = 0;

        while (true) {
            boolean changed = false;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] == 2) {
                        if (i > 0 && arr[i - 1][j] == 1) {
                            arr[i - 1][j] = 3;
                            changed = true;
                        }
                        if (i < m - 1 && arr[i + 1][j] == 1) {
                            arr[i + 1][j] = 3;
                            changed = true;
                        }
                        if (j > 0 && arr[i][j - 1] == 1) {
                            arr[i][j - 1] = 3;
                            changed = true;
                        }
                        if (j < n - 1 && arr[i][j + 1] == 1) {
                            arr[i][j + 1] = 3;
                            changed = true;
                        }
                    }
                }
            }

            if (!changed)
                break;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] == 3)
                        arr[i][j] = 2;
                }
            }

            ans++; // One full minute has passed
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1)
                    return -1;
            }
        }

        return ans;
    }
}
