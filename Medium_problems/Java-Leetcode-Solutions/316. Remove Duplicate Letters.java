class Solution {
    public String smallestSubsequence(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();
        boolean[] taken = new boolean[26];
        int[] lastIndex = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            lastIndex[ch - 'a'] = i;
        }

        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';
            
            if (taken[idx]) continue;
            // first check stack is not empty
            // second check the current char is smaller than stack top eg: a<d 
            // third check the last occurence of that char is greater than i, it means there is upcoming same char in string 
            while (!st.isEmpty() && s.charAt(i) < st.peek() && lastIndex[st.peek() - 'a'] > i) {
                char c=st.pop();
                taken[c - 'a'] = false;
            }
            
            st.push(s.charAt(i));
            taken[idx] = true;
        }
        
        StringBuilder result = new StringBuilder();
        while (!st.isEmpty()) {
            result.append(st.pop());
        }
        
        return result.reverse().toString();
    }
}
