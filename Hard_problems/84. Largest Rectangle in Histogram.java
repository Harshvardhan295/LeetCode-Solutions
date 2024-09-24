import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] height) {
        Stack<Integer> st = new Stack<>();
        int n = height.length;
        int[] leftsmall = new int[n];
        int[] rightsmall = new int[n];

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && height[st.peek()] >= height[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                leftsmall[i] = -1; 
            } else {
                leftsmall[i] = st.peek();
            }
            st.push(i);
        }

        while (!st.isEmpty()) st.pop();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && height[st.peek()] >= height[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                rightsmall[i] = n; 
            } else {
                rightsmall[i] = st.peek();
            }
            st.push(i);
        }

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int width = rightsmall[i] - leftsmall[i] - 1;
            maxArea = Math.max(maxArea, height[i] * width);
        }

        return maxArea;
    }
}

