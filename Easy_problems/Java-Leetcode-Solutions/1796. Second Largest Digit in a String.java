class Solution {
    public int secondHighest(String s) {
        int max = Integer.MIN_VALUE;
        int smax = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                if (c - '0' > max) {
                    smax = max;
                    max = c - '0';
                } else if (c - '0' > smax && c - '0' != max) {
                    smax = c - '0';
                }
            }
        }
        return smax == Integer.MIN_VALUE ? -1 : smax;
    }
}
