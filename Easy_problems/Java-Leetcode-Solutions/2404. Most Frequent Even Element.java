class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (num % 2 == 0) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }

        if (map.isEmpty()) return -1; 

        int maxFreq = 0;
        int minNum = Integer.MAX_VALUE;

        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (freq > maxFreq || (freq == maxFreq && key < minNum)) {
                maxFreq = freq;
                minNum = key;
            }
        }
        return minNum;
    }
}

