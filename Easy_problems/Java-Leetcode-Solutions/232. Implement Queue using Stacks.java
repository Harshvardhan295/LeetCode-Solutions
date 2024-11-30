class MyQueue {
     Stack<Integer> st;
     Stack<Integer> q;

    public MyQueue() {
        st = new Stack<>();
        q = new Stack<>();
    }
    
    public void push(int x) {
        st.push(x);
    }
    
    public int pop() {
        if (q.isEmpty()) {
            while (!st.isEmpty()) {
                q.push(st.pop());
            }
        }
        return q.pop();
    }
    
    public int peek() {
        if (q.isEmpty()) {
            while (!st.isEmpty()) {
                q.push(st.pop());
            }
        }
        return q.peek();
    }
    
    public boolean empty() {
        return st.isEmpty() && q.isEmpty();
    }
}
