class Solution {
    public boolean isPalindrome(String s) {
        // converted to lowercase
        String S = s.toLowerCase();
        
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {//used regular for loop
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
        // converted to lowercase
        String S = s.toLowerCase();
        
        StringBuilder str = new StringBuilder();
        for (char c : S.toCharArray()) {//used for each loop
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
