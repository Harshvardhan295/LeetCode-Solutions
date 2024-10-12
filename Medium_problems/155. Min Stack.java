// __________________Method 1: Using 2 stacks______________________
class MinStack {
    Stack<Integer> mainStack;
    Stack<Integer> minStack;

    public MinStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        mainStack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (!mainStack.isEmpty()) {
            int popped = mainStack.pop();
            if (minStack.peek() == popped) {
                minStack.pop();
            }
        }
    }

    public int top() {
        if (mainStack.isEmpty()) return -1;
        return mainStack.peek();
    }

    public int getMin() {
        if (minStack.isEmpty()) return -1;
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

// ________________________Method 2: using 1 stack_______________________
class MinStack {
    Stack<Integer> mainStack;
int min;
    public MinStack() {
        mainStack = new Stack<>();
        min=Integer.MAX_VALUE;
    }

    public void push(int val) {
        if ( val <= min) {
            mainStack.push(min);//push current min again before updating min
            min=val;//update minimum
        }
        mainStack.push(val);
    }

    public void pop() {
        if (mainStack.pop()==min) {
            min=mainStack.pop();//if poped element is equal to  min , pop again and put this poped element in min
        }
    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
