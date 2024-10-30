class Solution {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        int count = 0;
        Set<Integer> set = map.keySet();
        //keySet() gives a collection of the unique keys in the map
        for (int num : set) {
            if (k > 0 && map.containsKey(num + k)) {
                count++;
            }
            if (k == 0 && map.get(num) > 1) {
                //map.get() retrieves the value of a key
                count++;
            }
        }
        return count;
    }
}
