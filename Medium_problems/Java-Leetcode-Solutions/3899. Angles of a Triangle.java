class Solution {
    public double[] internalAngles(int[] s) {
        Arrays.sort(s);
        int a = s[0], b = s[1], c = s[2];
        if (a + b <= c)
            return new double[0];
        
        double[] ans = new double[s.length];
        
        // 2.0 forces floating-point division
        double cosA = (b*b + c*c - a*a) / (2.0 * b * c);
        double cosB = (a*a + c*c - b*b) / (2.0 * a * c);
        double cosC = (a*a + b*b - c*c) / (2.0 * a * b);

        ans[0] = Math.toDegrees(Math.acos(cosA));
        ans[1] = Math.toDegrees(Math.acos(cosB));
        ans[2] = Math.toDegrees(Math.acos(cosC));
        Arrays.sort(ans);
        return ans;
    }
}
