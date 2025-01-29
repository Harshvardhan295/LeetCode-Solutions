import java.util.HashMap;

class Solution {
    public int beautySum(String s) {
        int sum = 0;
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (int j = i; j < n; j++) {
                char ch = s.charAt(j);
                map.put(ch, map.getOrDefault(ch, 0) + 1);

                int maxfreq = Integer.MIN_VALUE;
                int minfreq = Integer.MAX_VALUE;
                
                for (int freq : map.values()) {
                    maxfreq = Math.max(maxfreq, freq);
                    minfreq = Math.min(minfreq, freq);
                }
                sum += (maxfreq - minfreq); 
            }
        }
        return sum;
    }
}
