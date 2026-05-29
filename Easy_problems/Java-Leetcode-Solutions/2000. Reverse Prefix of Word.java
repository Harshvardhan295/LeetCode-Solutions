class Solution {
    public String reversePrefix(String word, char ch) {
        int idx=word.indexOf(ch);
        if(idx==-1) return word;
        
        int i=0;
        StringBuilder str=new StringBuilder(word);
        while(i<idx){
            char temp=str.charAt(i);
            str.setCharAt(i, str.charAt(idx));
            str.setCharAt(idx, temp);
            i++;
            idx--;
        }
        return str.toString();
    }
}
