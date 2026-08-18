class Solution {
    public long maximumValue(int n, int s, int m) {
        if (n == 1)
            return s;

        long S = s;
        long N = n;
        long M = m;

        if (N % 2 == 0) {
            return S + (N / 2) * M - ((N - 1) / 2);
        } else {
            return S + (N / 2) * M - ((N / 2) - 1);
        }
    }
}
