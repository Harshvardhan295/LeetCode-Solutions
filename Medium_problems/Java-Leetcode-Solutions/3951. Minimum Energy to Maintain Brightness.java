class Solution {
    public long minEnergy(int n, int brightness, int[][] arr) {
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        long totallen = 0;
        int currentStart = arr[0][0];
        int currentEnd = arr[0][1];
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i][0] <= currentEnd) {//overlapping
                currentEnd = Math.max(currentEnd, arr[i][1]);
            } else {//not overlapping
                totallen += (long) (currentEnd - currentStart + 1);
                currentStart = arr[i][0];
                currentEnd = arr[i][1];
            }
        }
        totallen += (long) (currentEnd - currentStart + 1);

        long min_bulbs = (brightness + 2) / 3;
        return totallen * min_bulbs;
    }
}
