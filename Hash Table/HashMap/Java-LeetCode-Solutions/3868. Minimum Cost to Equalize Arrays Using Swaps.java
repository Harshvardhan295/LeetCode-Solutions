class Solution {
    public int minCost(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> totalmap = new HashMap<>();

        for(int num : nums1){
            map1.put(num, map1.getOrDefault(num,0) + 1);
            totalmap.put(num, totalmap.getOrDefault(num,0) + 1);
        }

        for(int num : nums2){
            map1.put(num, map1.getOrDefault(num,0) - 1);
            totalmap.put(num, totalmap.getOrDefault(num,0) + 1);
        }

        for(int val : totalmap.values()){
            if(val % 2 != 0) return -1;
        }

        int ans = 0;

        for(int val : map1.values()){
            ans += Math.abs(val) / 2;
        }

        return ans / 2;
    }
}
