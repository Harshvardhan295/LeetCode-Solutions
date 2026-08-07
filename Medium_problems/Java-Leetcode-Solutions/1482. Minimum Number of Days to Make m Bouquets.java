class Solution {
    public int minDays(int[] arr, int m, int k) {
        long required = (long) m * k;
        if (required > arr.length)
            return -1;

        int l = Integer.MAX_VALUE;
        int h = Integer.MIN_VALUE;

        for (int x : arr) {
            l = Math.min(l, x);
            h = Math.max(h, x);
        }

        while (l <= h) {
            int mid = l + (h - l) / 2;

            if (canMake(arr, m, k, mid)) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }

    private boolean canMake(int[] arr, int m, int k, int day) {
        int bouquets = 0;
        int flowers = 0;

        for (int x : arr) {
            if (x <= day) {
                flowers++;

                if (flowers == k) {
                    bouquets++;
                    flowers = 0;

                    if (bouquets >= m)
                        return true;
                }
            } else {
                flowers = 0;
            }
        }

        return false;
    }
}
