class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {

        long ans = Long.MAX_VALUE;

        ans = Math.min(ans,(long) need1 * cost1 + (long) need2 * cost2);

        int minNeed = Math.min(need1, need2);
        ans = Math.min(ans,(long) minNeed * costBoth +
                            (long) (need1 - minNeed) * cost1 +
                            (long) (need2 - minNeed) * cost2);

        int maxNeed = Math.max(need1, need2);
        ans = Math.min(ans,(long) maxNeed * costBoth);

        return ans;
    }
}
