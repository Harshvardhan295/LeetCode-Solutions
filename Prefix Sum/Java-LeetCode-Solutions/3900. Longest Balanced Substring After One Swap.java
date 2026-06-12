import java.util.*;

class Solution {
    public int longestBalanced(String s) {
        
        int n = s.length();

        int totalOnes = 0, totalZeros = 0;

        // Count total ones and zeros
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') totalOnes++;
            else totalZeros++;
        }

        int prefixOnes = 0, prefixZeros = 0;

        Map<Integer, List<Integer>> diffIndices = new HashMap<>();

        // Initialize
        diffIndices.put(0, new ArrayList<>());
        diffIndices.get(0).add(0);

        int maxLen = 0;

        for (int i = 1; i <= n; i++) {

            if (s.charAt(i - 1) == '1') prefixOnes++;
            else prefixZeros++;

            int diff = prefixOnes - prefixZeros;

            // Case 1: equal number of 1s and 0s
            if (diff == 0) maxLen = Math.max(maxLen, i);

            // Case 2: same diff seen before
            if (diffIndices.containsKey(diff)) {
                maxLen = Math.max(maxLen, i - diffIndices.get(diff).get(0));
            }

            // Case 3: adjust diff -2 / +2 cases
            if (diff < 0 && diffIndices.containsKey(diff + 2)) {
                for (int startIdx : diffIndices.get(diff + 2)) {
                    int requiredZeros = (i - startIdx) / 2;
                    if (totalOnes >= requiredZeros) {
                        maxLen = Math.max(maxLen, i - startIdx);
                    }
                }
            } 
            else if (diff > 0 && diffIndices.containsKey(diff - 2)) {
                for (int startIdx : diffIndices.get(diff - 2)) {
                    int requiredOnes = (i - startIdx) / 2;
                    if (totalZeros >= requiredOnes) {
                        maxLen = Math.max(maxLen, i - startIdx);
                    }
                }
            }

            // Store indices (limit size like C++ logic)
            diffIndices.putIfAbsent(diff, new ArrayList<>());
            if (diffIndices.get(diff).size() <= 1) {
                diffIndices.get(diff).add(i);
            }
        }

        return maxLen;
    }
}
