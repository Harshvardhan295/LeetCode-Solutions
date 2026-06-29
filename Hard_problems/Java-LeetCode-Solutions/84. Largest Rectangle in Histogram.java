// Stack solution 1
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

// Stack Solution 2
class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int currArea = 0;
        Stack<Integer> stack = new Stack();

        for (int i = 0; i < heights.length; i++) {
            // if (stack.isEmpty() || heights[i] >= heights[stack.peek()]) {
            //     stack.push(i);
            // } 
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int topIdx = stack.pop();
                int leftBoundary = stack.isEmpty() ? -1 : stack.peek();
                int width = i - leftBoundary - 1;
                int area = heights[topIdx] * width;
                currArea = Math.max(currArea, area);
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int topIdx = stack.pop();
            int leftBoundary = stack.isEmpty() ? -1 : stack.peek();
            int width = heights.length - leftBoundary - 1;
            int area = heights[topIdx] * width;
            currArea = Math.max(currArea, area);
        }
        return currArea;
    }
}
