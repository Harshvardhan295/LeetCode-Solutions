class Solution {
    public int closestTarget(String[] str, String t, int idx) {
        int n = str.length;
        int minDist = Integer.MAX_VALUE;
        boolean found = false;

        for (int i = 0; i < n; i++) {
            if (str[i].equals(t)) {
                found = true;
                int absDiff = Math.abs(i - idx);
                // Compare direct distance vs circular wraparound distance
                int currentDist = Math.min(absDiff, n - absDiff);
                minDist = Math.min(minDist, currentDist);
            }
        }

        return found ? minDist : -1;
    }
}
