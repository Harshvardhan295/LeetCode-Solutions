import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                st.push(')'); 
            } else if (c == '{') {
                st.push('}'); 
            } else if (c == '[') {
                st.push(']'); 
            } else {// If stack is empty or the top of the stack doesn't match the current character
                if (st.isEmpty() || st.pop() != c) {
                    return false;
                }
            }
        }
        
        return st.isEmpty(); //if empty then true
    }
}

