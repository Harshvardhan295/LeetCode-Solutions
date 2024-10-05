//______________ Method 1 (efficient method)________________
class Solution {
    public int lengthOfLastWord(String s) {
        int length = 0;
        int i = s.length() - 1;//begin with end
        
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }
        return length;
    }
}

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
