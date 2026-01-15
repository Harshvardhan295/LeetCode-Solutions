class Solution {
    public int residuePrefixes(String s) {
        HashSet<Character> set=new HashSet<>();
        int len=0, ans=0;
        for (int i=0;i<s.length();i++){
            set.add(s.charAt(i));
            len++;
             if(set.size()== len%3) ans++;
        }
        return ans;
    }
}
