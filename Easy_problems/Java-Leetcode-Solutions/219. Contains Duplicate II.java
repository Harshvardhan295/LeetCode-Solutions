//Brute force
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n=nums.length;
         for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(nums[i]==nums[j] && Math.abs(i-j)<=k) return true;
            }
         }
        return false;

    }
}
//Hashmap
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(map.containsKey(nums[i])){
                int j=map.get(nums[i]);
                if(i-j<=k) return true;
            }
            map.put(nums[i],i);
        }
        return false;
    }
}
//Hashset and Sliding window
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (i > k)  set.remove(nums[i - k - 1]);
            if (set.contains(nums[i])) return true; // Duplicate found within the window of size k
            set.add(nums[i]);
        }
        return false; // No duplicate found within the given distance k
    }
}
