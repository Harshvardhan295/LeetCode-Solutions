class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> l = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        int threshold = nums.length / 3;
        for (int key : map.keySet()) {
            if (map.get(key) > threshold) {
                l.add(key);
            }
        }
    
        return l;
    }
}
