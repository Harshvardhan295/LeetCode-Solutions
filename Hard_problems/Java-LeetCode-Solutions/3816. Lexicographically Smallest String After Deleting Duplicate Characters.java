class Solution {
    public String lexSmallestAfterDeletion(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        Stack<Character> st = new Stack<>();

        for(int i=0 ; i<s.length() ; i++){
            while(!st.isEmpty() && st.peek()>s.charAt(i) && map.get(st.peek())>1){
                map.put(st.peek(),map.get(st.peek())-1);
                st.pop();
            }
            st.push(s.charAt(i));
        }
        while(!st.isEmpty() && map.get(st.peek())>1){
            map.put(st.peek(),map.get(st.peek())-1);
            st.pop();
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : st) {
            sb.append(ch);
        }
        return sb.toString();
    }
}
