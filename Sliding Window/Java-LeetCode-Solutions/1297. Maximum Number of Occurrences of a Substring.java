class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int n = s.length();
        int maxOcc = 0;
        // Maps the substring of length minSize to its frequency count
        Map<String, Integer> counts = new HashMap<>();
        // easily track unique characters inside our window
        int[] charFreq = new int[26];
        int uniqueLetters = 0;

        // Loop through the string, maintaining a window of size 'minSize'
        for (int i = 0; i < n; i++) {
            // 1. Add the new character entering the window from the right
            int rightCharIdx = s.charAt(i) - 'a';
            if (charFreq[rightCharIdx] == 0) {
                uniqueLetters++;
            }
            charFreq[rightCharIdx]++;

            // 2. If the window grows larger than minSize, slide the left side out
            // checking minSize will always give us the highest possible answer.
            //Let's look at an example where minSize = 2 and maxSize = 4.
            // Suppose the substring "abab" appears 3 times in a text.
            // If you break "abab" down into smaller parts of length 2 (minSize), you get:
            //"ab"
            //"ba"
            //Since "abab" appears 3 times, the smaller piece "ab" is guaranteed to appear at least 3 times as well (in fact, it might appear even more if it exists elsewhere on its own).
            if (i >= minSize) {
                int leftCharIdx = s.charAt(i - minSize) - 'a';
                charFreq[leftCharIdx]--;
                if (charFreq[leftCharIdx] == 0) {
                    uniqueLetters--;
                }
            }

            // 3. Once the window hits exactly minSize, check if it meets constraints
            if (i >= minSize - 1) {
                if (uniqueLetters <= maxLetters) {
                    // Extract the substring and update its frequency count
                    String sub = s.substring(i - minSize + 1, i + 1);
                    int currentCount = counts.getOrDefault(sub, 0) + 1;
                    counts.put(sub, currentCount);
                    
                    // Keep track of the highest frequency seen so far
                    maxOcc = Math.max(maxOcc, currentCount);
                }
            }
        }

        return maxOcc;
    }
}
