class Solution {
     public int countPalindromicSubsequence(String s) {
        if (s == null || s.length() < 3) return 0;
        HashMap<Character,Integer> fmap=new HashMap<>();
        HashMap<Character,Integer> lmap=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(!fmap.containsKey(ch)) fmap.put(ch,i);
            lmap.put(ch,i);
        }
        int count=0;
        for(char ch:fmap.keySet()){
            int firstocc=fmap.get(ch);
            int lastocc=lmap.get(ch);
            Set<Character> set=new HashSet<>();
            if(firstocc!=lastocc){
                for(int i=firstocc+1;i<lastocc;i++){
                    set.add(s.charAt(i));
                }
            }
            count+=set.size();
        }
        return count;
    }
}
