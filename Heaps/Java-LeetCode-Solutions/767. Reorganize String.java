class Solution {
    class Pair implements Comparable<Pair> {
        char ch;
        int freq;

        Pair(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }

        public int compareTo(Pair p) {
            return p.freq - this.freq; // max heap
        }
    }

    public String reorganizeString(String s) {
        int n = s.length();
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        // rearrangement not possible check
        for (int f : freq) {
            if (f > (n + 1) / 2) return "";
        }

        //arrangement
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                pq.add(new Pair((char) ('a' + i), freq[i]));
            }
        }

        StringBuilder ans = new StringBuilder();

        Pair prev = null;
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            ans.append(curr.ch);
            curr.freq--;

            if (prev != null && prev.freq > 0) {
                pq.add(prev);
            }

            prev = curr;
        }

        return ans.toString();
    }
}
