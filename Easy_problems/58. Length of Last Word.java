// ___________ Method 2__________________
  class Solution {
    public int lengthOfLastWord(String s) {
        if (s.length() == 0)
            return 0;
        
        s = s.trim(); // Remove any trailing spaces
        int count = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                count += 1;
            } else {
                count = 0; 
            }
        }
        return count;
    }
}
