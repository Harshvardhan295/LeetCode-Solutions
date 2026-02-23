class Solution {
    public String maximumXor(String s, String t) {
        int ones = 0, zeros = 0;
        for (char c : t.toCharArray()) {
            if (c == '1') ones++;
            else zeros++;
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '1') {
                if (zeros > 0) {
                    ans.append('1');
                    zeros--;
                } else {
                    ans.append('0');
                    ones--;
                }
            } else { 
                if (ones > 0) {
                    ans.append('1');
                    ones--;
                } else {
                    ans.append('0');
                    zeros--;
                }
            }
        }

        return ans.toString();
    }
}
