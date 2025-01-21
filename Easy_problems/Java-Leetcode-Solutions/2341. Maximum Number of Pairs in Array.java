class Solution {
    public int[] numberOfPairs(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int pairs = 0;

        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
                pairs++;
            } else {
                set.add(num);
            }
        }
        // numbers which don't have any pairs
        int leftovers = set.size();
        int[] arr = new int[2];
        arr[0] = pairs;
        arr[1] = leftovers;
        return arr;
    }
}
