// Optimised
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        int[] freq = new int[26];

        for (char c : magazine.toCharArray()) {
            freq[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            if (freq[c - 'a'] == 0) {
                return false;
            }
            freq[c - 'a']--;
        }

        return true;
    }
}
//Simple
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> mp = new HashMap<>();
        for (char c : ransomNote.toCharArray()) {
            mp.put(c, mp.getOrDefault(c, 0) + 1);
        }
        HashMap<Character, Integer> mp2 = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            mp2.put(c, mp2.getOrDefault(c, 0) + 1);
        }
        if (mp.size() > mp2.size())
            return false;
        for (char c : ransomNote.toCharArray()) {
            if(!mp2.containsKey(c)) return false;
            if ( mp.get(c) > mp2.get(c))
                return false;
        }
        return true;
    }
}
