class Solution {
    public boolean canBeEqual(String s1, String s2) {
        if (s1.equals(s2))
            return true;
        int j = 2, i = 0;
        while (j <4) {
            if(s1.charAt(i) == s2.charAt(i) && s1.charAt(j) == s2.charAt(j)) {
                i++; j++;
            }
            else if (s1.charAt(i) == s2.charAt(j) && s1.charAt(j) == s2.charAt(i)) {
                i++; j++;
            }
            else return false;
        }

        return true;
    }
}
