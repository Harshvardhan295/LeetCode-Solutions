class Solution {
    public boolean isPalindrome(String s) {
        String S = s.toLowerCase();
        
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (Character.isLetterOrDigit(S.charAt(i))) {
                str.append(S.charAt(i));
            }
        }
        
        int k = str.length() - 1;
        int l = 0;
        while (l < k) {  
            if (str.charAt(l) != str.charAt(k)) {
                return false;
            }
            l++;
            k--;
        }
        return true;
    }
}
________________________________________________
class Solution {
    public boolean isPalindrome(String s) {
        // to lowercase
        String S = s.toLowerCase();
        
        StringBuilder str = new StringBuilder();
        for (char c : S.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                str.append(c);
            }
        }
        
        int k = str.length() - 1;
        int l = 0;
        while (l < k) {  
            if (str.charAt(l) != str.charAt(k)) {
                return false;
            }
            l++;
            k--;
        }
        return true;
    }
}
