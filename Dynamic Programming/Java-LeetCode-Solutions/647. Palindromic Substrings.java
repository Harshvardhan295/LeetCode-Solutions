//Brute force
class Solution {
    //Brute force
    public static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }

    public static int generateAllSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String sub = s.substring(i, j);
                if (isPalindrome(sub)) count++;
            }
        }
        return count;
    }

    public int countSubstrings(String s) {
        return generateAllSubstrings(s);
    }
}
//DP
class Solution {
    public int countSubstrings(String s) {
        int n = s.length(), count = 0;
        int[][] dp = new int[n][n];
        
        for (int k = 0; k < n; k++) {
            int i = 0, j = k;
            while (j < n) {
                if(i==j){//String length=1
                    dp[i][i] = 1;
                    count++;
                }
                else if (j == i + 1) {//String length=2
                    if (s.charAt(i) == s.charAt(j)){
                        dp[i][j] = 1;
                        count++;
                    }
                } else {//String length>2
                    if (s.charAt(i) == s.charAt(j)){
                        if(dp[i + 1][j - 1] == 1) {
                            dp[i][j] = 1;
                            count++;
                        }
                    } 
                }
                i++;j++;
            }
        }
        return count;
    }
}
