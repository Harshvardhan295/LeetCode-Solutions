import java.util.*;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> l = new ArrayList<>();
        if (nums.length == 1) { 
            l.add(nums[0]);
            return l;
        }

        Arrays.sort(nums);
        int threshold = nums.length / 3;
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                if (count > threshold) {
                    l.add(nums[i - 1]); //Add the previous number before resetting count
                }
                count = 1; 
            }
        }

        if (count > threshold) {
            l.add(nums[nums.length - 1]);
        }

        return l;
    }
}
//hashmaps
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
