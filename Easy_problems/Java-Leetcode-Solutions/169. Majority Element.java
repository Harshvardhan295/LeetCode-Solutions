//Using Hashmaps
class Solution {
    public int majorityElement(int[] a) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int ele : a) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }
        
        int ans = -1, max = 0;
        for (int ele : map.keySet()) {
            if (map.get(ele) > max) {
                max = map.get(ele);
                ans = ele;
            }
        }
        return ans; 
    }
}
//O(nlogn)
class Solution {
    public int majorityElement(int[] a) {
        int n=a.length;
        Arrays.sort(a);
        return a[n/2];
    }
}
