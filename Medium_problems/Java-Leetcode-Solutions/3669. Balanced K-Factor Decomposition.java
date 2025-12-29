class Solution {
    public void backtrack(int n, int k, int start, List<Integer> curr, List<Integer> best) {

        if (k < 0) return;

        if (k == 0 && n == 1) {
            int max = Collections.max(curr);
            int min = Collections.min(curr);
            int d = max - min;

            if (best.isEmpty() || d < (Collections.max(best) - Collections.min(best))) {
                best.clear();
                best.addAll(curr);
            }
            return;
        }

        for (int i = start; i <= n; i++) {
            if (n % i == 0) {
                curr.add(i);
                backtrack(n / i, k - 1, i, curr, best);
                curr.remove(curr.size() - 1);
            }
        }
    }

    public int[] minDifference(int n, int k) {
        List<Integer> best = new ArrayList<>();
        backtrack(n, k, 1, new ArrayList<>(), best);

        int[] ans = new int[best.size()];
        for (int i = 0; i < best.size(); i++) {
            ans[i] = best.get(i);
        }
        return ans;
    }
}
