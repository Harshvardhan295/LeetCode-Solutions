import java.util.*;

class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        long ans = 0;

        Deque<Integer> maxD = new ArrayDeque<>(); // decreasing
        Deque<Integer> minD = new ArrayDeque<>(); // increasing

        int i = 0;

        for (int j = 0; j < n; j++) {

            // Maintain max deque
            while (!maxD.isEmpty() && nums[maxD.peekLast()] <= nums[j]) {
                maxD.pollLast();
            }
            maxD.addLast(j);

            // Maintain min deque
            while (!minD.isEmpty() && nums[minD.peekLast()] >= nums[j]) {
                minD.pollLast();
            }
            minD.addLast(j);

            // Shrink window if cost > k
            while (i <= j) {
                long maxVal = nums[maxD.peekFirst()];
                long minVal = nums[minD.peekFirst()];
                long cost = (maxVal - minVal) * (long) (j - i + 1);

                if (cost > k) {
                    if (maxD.peekFirst() == i)
                        maxD.pollFirst();
                    if (minD.peekFirst() == i)
                        minD.pollFirst();
                    i++;
                } else {
                    break;
                }
            }
            ans += (long) (j - i + 1);
        }
        return ans;
    }
}
