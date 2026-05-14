class Solution {
    public int minAbsoluteDifference(int[] nums) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 2)
                l2.add(i);
            else if (nums[i] == 1)
                l1.add(i);
        }
        if (l1.size() == 0 || l2.size() == 0)
            return -1;
        int min = Integer.MAX_VALUE;
        int s2 = l2.size();
        for (int i = 0; i < l1.size(); i++) {
            int j = 0;
            while (j < s2) {
                int diff = Math.abs(l1.get(i) - l2.get(j));
                min=Math.min(min,diff);
                j++;
            }
        }
        return min;
    }
}
