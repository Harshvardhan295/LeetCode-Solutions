// Simple optimised math + stack solution
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 2 * n - 1; i >= 0; i--) {
            int curr = nums[i % n];
            while (!st.isEmpty() && st.peek() <= curr) {
                st.pop();
            }
            if (i < n) {
                ans[i] = st.isEmpty() ? -1 : st.peek();
            }
            st.push(curr);
        }

        return ans;
    }
}

// Stack solution
class Solution {
    public int[] nextGreaterElements(int[] arr) {
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            l.add(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            l.add(arr[i]);
        }
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];

        for (int i = l.size() - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= l.get(i)) {
                st.pop();
            }
            if (i < arr.length) {
                ans[i] = st.isEmpty() ? -1 : st.peek();
            }
            st.push(l.get(i));
        }
        return ans;
    }
}
