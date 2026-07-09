class Solution {
    public boolean isAdjacentDiffAtMostTwo(String s) {
        char[] c=s.toCharArray();
        for(int i=1;i<s.length();i++){
            if(Math.abs(c[i]-c[i-1])>2) return false;
        }
        return true;
    }
}
