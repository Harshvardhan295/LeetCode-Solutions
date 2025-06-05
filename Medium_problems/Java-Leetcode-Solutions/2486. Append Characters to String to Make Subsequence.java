class Solution {
    public int appendCharacters(String s, String t) {
        int ans=t.length();
        int j=0;
        for(int i=0;i<s.length();i++){
            if(j==t.length()) break; 
            if(s.charAt(i)==t.charAt(j)){
                ans--;
                j++;
            }
        }
        return ans;
    }
}
//Cleaner version
class Solution {
    public int appendCharacters(String s, String t) {
        int j = 0;
        for (int i = 0; i < s.length() && j < t.length(); i++) {
            if (s.charAt(i) == t.charAt(j)) j++;
        }
        return t.length() - j;
    }
}
