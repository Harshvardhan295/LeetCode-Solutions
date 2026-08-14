class Solution {
    public String rearrangeString(String s, char x, char y) {
        // If either character is missing, return the original string
        if (s.indexOf(x) == -1 || s.indexOf(y) == -1)
            return s;

        int[] freq = new int[26];
        int len = s.length();

        for (int i = 0; i < len; i++) {
            freq[s.charAt(i) - 'a']++;
        }

        StringBuilder ans = new StringBuilder(len);

        // Process character 'y' first as intended
        while (freq[y - 'a'] > 0) {
            ans.append(y);
            freq[y - 'a']--;
        }

        // Safely loop through the alphabet (0 to 25) 
        for (int i = 0; i < 26; i++) {
            char currentChar = (char) (i + 'a');
            while (freq[i] > 0) {
                ans.append(currentChar);
                freq[i]--;
            }
        }

        return ans.toString();
    }
}
