class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        if (k == 1)
            return n; //each character can be a substring

        boolean[][] isPalindrome = new boolean[n][n];

        //Palindromic substring Blueprint
        for (int L = 1; L <= n; L++) {
            for (int i = 0; i + L <= n; i++) {
                int j = i + L - 1;

                if (i == j) {
                    isPalindrome[i][i] = true; //Single characters are palindrome
                } else if (i + 1 == j) {
                    isPalindrome[i][j] = (s.charAt(i) == s.charAt(j)); //Strings of 2 Length
                } else {
                    isPalindrome[i][j] = (s.charAt(i) == s.charAt(j)) && isPalindrome[i + 1][j - 1];
                }
            }
        }

        int[][] t = new int[n + 1][n + 1];

        for (int i = n - 1; i >= 0; --i) {
            for (int j = n - 1; j >= i; --j) {

                if (isPalindrome[i][j]) {
                    int growWindow  = t[i][j + 1];
                    int takeIt      = 1 + (j + k <= n ? t[j + 1][j + k] : 0);
                    int slideWindow = t[i + 1][j + 1];

                    t[i][j] = Math.max(growWindow, Math.max(takeIt, slideWindow));
                }

                int slideWindow = t[i + 1][j + 1];
                int growWindow  = t[i][j + 1];
                t[i][j] = Math.max(t[i][j], Math.max(slideWindow, growWindow));
            }
        }

        return t[0][k - 1];
    }
}
