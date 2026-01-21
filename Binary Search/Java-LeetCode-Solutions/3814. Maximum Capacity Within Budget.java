class Solution {
    public int maxCapacity(int[] costs, int[] capacity, int budget) {
        int n = costs.length,ans = 0;
        //combine capacity and costs to form single array
        int[][] a = new int[n][2];
        for (int i = 0; i < n; i++) { 
            a[i][0] = costs[i];
            a[i][1] = capacity[i];
        }

        Arrays.sort(a, (x, y) -> x[0] - y[0]); //sort that array

        // find the best or max capacity upto each index
        int[] best = new int[n];
        best[0] = a[0][1];
        for (int i = 1; i < n; i++) {
            best[i] = Math.max(best[i - 1], a[i][1]);
        }

        // For Single Machine
        for (int i = 0; i < n; i++) {
            if (a[i][0] < budget) {
                ans = Math.max(ans, a[i][1]);
            }
        }
        // For Second Machine
        for (int j = 1; j < n; j++) {
            int rem = budget - a[j][0] - 1;
            int i = upperBound(a, rem, j - 1);
            if (i >= 0) {
                ans = Math.max(ans, best[i] + a[j][1]);
            }
        }
        return ans;
    }

    public int upperBound(int[][] a, int budget, int r) {
        int l = 0, idx = -1;

        while (l <= r) {
            int m = (l + r) / 2;
            if (a[m][0] <= budget) {
                idx = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return idx;
    }
}B
