class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        //Min heap, it will sort for a[0]->value
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int i = 0; i < nums.length; i++) {
            pq.offer(new int[]{nums[i], i});//a[0]= val , a[1]=index
            if (pq.size() > k) pq.poll();
            //as size exceeds k, the min val at the top is removed
        }

        List<int[]> list = new ArrayList<>(pq);
        // sort by index
        Collections.sort(list, (a, b) -> a[1] - b[1]);

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = list.get(i)[0];
        }

        return res;
    }
}
