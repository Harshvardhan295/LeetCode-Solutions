//Method 1
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
            min=mainStack.pop();//if poped element is equal to  min , pop again 
        }
    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        return min;
    }
}

