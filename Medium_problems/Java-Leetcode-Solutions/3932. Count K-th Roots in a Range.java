//M1
class Solution {
        public int countKthRoots(int l, int r, int k) {
        if (k == 1) {
            return r - l + 1;
        }
        int res = 0, maxx = (int) Math.pow(r, 1.0 / k) + 1;
        for (int x = 0; x <= maxx; x++) {
            long y = Math.round(Math.pow(x, k));
            if (l <= y && y <= r) {
                res++;
            }
        }
        return res;
    }
}
// M2
class Solution {
    public int countKthRoots(int l, int r, int k) {
        double p = 1.0 / k;

        int left = (int)Math.ceil(Math.pow(l, p) - 1e-10);
        int right = (int)Math.floor(Math.pow(r, p) + 1e-10);

        return Math.max(0, right - left + 1);
    }
}
