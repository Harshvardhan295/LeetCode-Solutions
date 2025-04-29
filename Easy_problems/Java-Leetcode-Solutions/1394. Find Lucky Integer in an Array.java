class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer,Integer> map= new HashMap<>();
        int ans=-1;
        for (int ele : arr) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }   
        for (int key : map.keySet()) {
            if (key == map.get(key)) {
                ans = Math.max(ans, key);
            }
        } 
        return ans;
    }
}
