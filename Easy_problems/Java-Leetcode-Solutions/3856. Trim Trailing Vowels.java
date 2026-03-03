class Solution {
    public String trimTrailingVowels(String s) {
        StringBuilder str=new StringBuilder(s);
        int i=s.length()-1;
        while(i>=0){
            if("aeiou".indexOf(str.charAt(i))!=-1) {
                str.deleteCharAt(i--);
            }
            else break;
        }
        return str.toString();
    }
}
