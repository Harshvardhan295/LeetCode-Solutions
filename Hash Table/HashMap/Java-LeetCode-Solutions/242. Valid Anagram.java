class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length())
            return false;
        HashMap<Character, Integer> map1 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map1.containsKey(ch)) {
                int freq = map1.get(ch);
                map1.put(ch, freq + 1);
            } else
                map1.put(ch, 1);
        }
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (map2.containsKey(ch)) {
                int freq = map2.get(ch);
                map2.put(ch, freq + 1);
            } else
                map2.put(ch, 1);
        }
        for (char ch: map1.keySet()) {
            int val1 = map1.get(ch);
             if (!map2.containsKey(ch))
                return false;
            int val2 = map2.get(ch);
            if (val1 != val2)
                return false;
        }
        return true;
    }
}
