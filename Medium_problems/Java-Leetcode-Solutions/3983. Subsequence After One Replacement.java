class Solution {
    public boolean canMakeSubsequence(String s, String t) {
        int i = 0, j = 0;
        int n = s.length();

        for (char c : t.toCharArray()) {
            if (i < n && s.charAt(i) == c)
                i++;

            i = Math.max(i, j + 1);

            if (j < n && s.charAt(j) == c)
                j++;

            if (i == n || j == n)
                return true;
        }

        return false;
    }
}
