import java.util.*;

class Solution {
    public int minimumDistance(int[] nums) {
        HashMap<Integer, List<Integer>> mp = new HashMap<>();
        int minDis = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            mp.putIfAbsent(nums[i], new ArrayList<>());
            mp.get(nums[i]).add(i);

            List<Integer> list = mp.get(nums[i]);

            if (list.size() == 3) {
                int i1 = list.get(0);
                int i2 = list.get(1);
                int i3 = list.get(2);

                int distance = Math.abs(i1 - i2) + Math.abs(i2 - i3) + Math.abs(i3 - i1);
                minDis = Math.min(minDis, distance);

                // Remove first index to keep only last 3 occurrences (sliding window)
                list.remove(0);
            }
        }

        return (minDis != Integer.MAX_VALUE) ? minDis : -1;
    }
}
