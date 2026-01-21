class Solution {
    public int minOperations(int[] nums, int[] target) {
        Set<Integer> needOp = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target[i]) {
                needOp.add(nums[i]);
            }
        }
        return needOp.size();
    }
}
