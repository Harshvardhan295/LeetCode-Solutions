class Solution {
    public List<List<Integer>> subsets(int[] arr) {
        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();
        int total = (1 << n);
        for (int num = 0; num < total; num++) {
            List<Integer> l = new ArrayList<>();
            for (int bitidx = 0; bitidx < n; bitidx++) {
                int mask = (1 << bitidx);
                if ((num & mask) != 0) {
                    l.add(arr[bitidx]);
                }
            }
            ans.add(l);
        }
        return ans;
    }
}
