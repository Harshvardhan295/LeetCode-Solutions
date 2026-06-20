// Optimised Solution
class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        
        int open = 0;

        // First pass: remove invalid ')'
        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);

            if (ch == '(') {
                open++;
            } else if (ch == ')') {
                if (open > 0) {
                    open--;
                } else {
                    sb.setCharAt(i, '#'); // mark invalid ')'
                }
            }
        }

        // Second pass: remove extra '('
        for (int i = sb.length() - 1; i >= 0 && open > 0; i--) {
            if (sb.charAt(i) == '(') {
                sb.setCharAt(i, '#'); // mark invalid '('
                open--;
            }
        }

        // Build final answer
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != '#') {
                result.append(sb.charAt(i));
            }
        }

        return result.toString();
    }
}

// Stack Solution
class Solution {
    public String minRemoveToMakeValid(String s) {
        int n = s.length();
        Stack<Integer> st = new Stack<>();
        List<Integer> remove = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (Character.isLetter(s.charAt(i)))
                continue;
            else if (s.charAt(i) == ')' && st.isEmpty()) {
                remove.add(i);
            } else if (s.charAt(i) == ')' && !st.isEmpty())
                st.pop();
            else if (s.charAt(i) == '(')
                st.push(i);
        }

        while(!st.isEmpty()) {
            remove.add(st.pop());
        }
        String ans="";
        for(int i=0;i<n;i++){
            if(remove.contains(i)) continue;
            ans+=s.charAt(i);
        }
        return ans;
    }
}
