class Solution {

    public int maxLen(int[] Bars) {

        //'bars' tracks the current maxbars of consecutive bars
        // 'maxbars' stores the maximum consecutive bars found so far
        int bars = 1, maxbars = 1;

        for (int i = 1; i < Bars.length; i++) {
            // If the difference between two bars is 1,
            // they are consecutive bars that were removed
            // Example: [2,3,4]
            if (Bars[i] - Bars[i - 1] == 1) bars++;  

            // If bars are not consecutive
            else bars = 1;

            maxbars = Math.max(maxbars, bars);
        }

        // If k consecutive bars are removed,
        // they merge (k + 1) cells in the grid
        // Example:
        // removed bars: 2,3 → 2 consecutive bars
        // resulting gap = 3 cells
        return maxbars + 1;
    }

    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int horizontalGap = maxLen(hBars);
        int verticalGap = maxLen(vBars);

        // A square must have equal height and width.
        // Even if one direction allows a bigger gap,
        // the smaller direction limits the square size.
        int side = Math.min(horizontalGap, verticalGap);

        // bars of square = side * side
        return side * side;
    }
}
