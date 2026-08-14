class Solution {
    public boolean canReach(int[] start, int[] target) {
        int sum = start[0] + start[1] + target[0] + target[1];
        return sum % 2 == 0;
    }
}
