// Optimised Solution
class Solution {
    public int minAddToMakeValid(String s) {
        int n = s.length();

        int ans = 0, open = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;
            } else {
                if (open > 0) {
                    open--;
                } else {
                    ans++;
                }
            }
        }
        return ans + open;
    }

}
// Stack solution
class Solution {
    public int minAddToMakeValid(String s) {
        int n=s.length();
        Stack<Character> st=new Stack<>();
        int ans=0;
        for(char c:s.toCharArray()){
            if(st.isEmpty() && c==')') ans++;
            else if(c=='(') st.push(c);
            else st.pop();
        }
        while(!st.isEmpty()) {
            ans++;
            st.pop();
        }
        return ans;
    }

}
