class Solution {
    public int vowelConsonantScore(String s) {
        int c=0,v=0;
        Set<Character> set=new HashSet<>();
        set.add('a');set.add('e');
        set.add('i');set.add('o');
        set.add('u');
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (set.contains(ch)) v++;
            else if (Character.isLetter(ch)) c++; //ch >= 'a' && ch <= 'z'
        }
        if(c<=0) return 0;
        return v/c;
    }
}
