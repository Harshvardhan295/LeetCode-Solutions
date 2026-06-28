// List solution
class MinStack {
    List<Integer> data;
    public MinStack() {
        data=new ArrayList<>();
    }
    
    public void push(int val) {
        data.add(val);
    }
    
    public void pop() {
        data.remove(data.size()-1);
    }
    
    public int top() {
        return data.get(data.size()-1);
    }
    
    public int getMin() {
        int min=Integer.MAX_VALUE;
        for(int i=0;i<data.size();i++){
            min=Math.min(min,data.get(i));
        }
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

// Stack Solution
class MinStack {
    Stack<Integer> mainStack;
    int min;
    public MinStack() {
        mainStack = new Stack<>();
        min=Integer.MAX_VALUE;
    }

    public void push(int val) {
        if (val <= min) {
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

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
