//Method 1 - Bit Manipulation
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
//Method 2 - Backtracking
class Solution {
        static List<List<Integer>> arraylist = new ArrayList<>(); // global

    public static void printsubsetarray(int i, int[] arr, ArrayList<Integer>currentsubset) {
        if (i == arr.length) {
            arraylist.add(new ArrayList<Integer>(currentsubset));
            return;
        }
        printsubsetarray(i + 1, arr, currentsubset); // Not take
        currentsubset.add(arr[i]);
        printsubsetarray(i + 1, arr, currentsubset); // Take
        currentsubset.remove(currentsubset.size() - 1);
    }
    public List<List<Integer>> subsets(int[] arr) {
        arraylist=new ArrayList<>();
       printsubsetarray(0,arr,new ArrayList<>());
        return arraylist;
    }
}
