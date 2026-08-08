class Solution {
    public long sumAndMultiply(int n) {
        if(n==0) return 0;
        long sum = 0;
        StringBuilder sb = new StringBuilder();

        while (n != 0) {
            long d = n % 10;
            if (d != 0) {
                sum += d;
                sb.append(d);
            }
            n /= 10;
        }
        sb.reverse();

        long res = Long.parseLong(sb.toString());
        return sum * res;
    }
}
