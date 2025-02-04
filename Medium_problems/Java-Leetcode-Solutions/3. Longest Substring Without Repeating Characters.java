//Using Hashmaps
class Solution {
     public int lengthOfLongestSubstring(String s) {
        if(s.length()<=0) return s.length();
        HashMap<Character,Integer> map=new HashMap<>();
        int n=s.length();
        int maxlen=0,i=0,j=0;
        while(j<n){
            char ch=s.charAt(j);
            if(map.containsKey(ch) && map.get(ch)>=i){
                int len=j-i;
                maxlen=Math.max(len,maxlen);

                while(s.charAt(i)!=ch) i++;
                i++;
            }
            map.put(s.charAt(j),j);
            j++;
        }
        int len=j-i;
        maxlen=Math.max(len,maxlen);
        return maxlen;
    }
}
