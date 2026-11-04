class Solution {
    public int maxDepth(String s) {
        int max = Integer.MIN_VALUE;
        int a = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                a++;
                max = Math.max(max, a);
            } else if (s.charAt(i) == ')') {
                a--;
            }
        }
        return (max == Integer.MIN_VALUE) ? 0 : max;
    }
}
