//heaps
class Solution {
    public class Triplet implements Comparable<Triplet> {
        int ele;
        int row;
        int col;

        Triplet(int ele, int row, int col) {
            this.ele = ele;
            this.row = row;
            this.col = col;
        }

        public int compareTo(Triplet t) {
            return this.ele - t.ele;
        }
    }

    public int[] smallestRange(List<List<Integer>> nums) {
        int[] ans = { 0, Integer.MAX_VALUE };
        // MinHeap
        PriorityQueue<Triplet> pq = new PriorityQueue<Triplet>();
        int k = nums.size();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            int ele = nums.get(i).get(0);
            pq.add(new Triplet(ele, i, 0));
            max = Math.max(max, ele);
        }
        while (true) {
            Triplet top = pq.remove();
            int ele = top.ele, row = top.row, col = top.col;
            // update the minimum range
            if (max - ele < ans[1] - ans[0]) {
                ans[0] = ele;
                ans[1] = max;
            }
            if (col == nums.get(row).size() - 1)
                break;
            int nextele = nums.get(row).get(col + 1);
            max = Math.max(nextele, max);
            pq.add(new Triplet(nextele, row, col + 1));
        }
        return ans;
    }
}
