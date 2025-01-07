class Solution {
    public String clearDigits(String s) {
        Stack<String> st=new Stack<>();
        char[] str = new char[s.length()];
        int j=0;
        for(int i=0;i<s.length();i++){
            if (s.charAt(i) > 96 && s.charAt(i) < 123){
                st.push(s.charAt(i));   
            }
            else{
                st.pop(s.charAt(i));

            }
        }
        while(!st.isEmpty()){
            str[j]=st.pop();
        }
        Collections.reverse(str);
    }
}
