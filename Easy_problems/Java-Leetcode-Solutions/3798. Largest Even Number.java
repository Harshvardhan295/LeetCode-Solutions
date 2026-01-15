class Solution {
    public String largestEven(String s) {
        int n=s.length();
        char[] ch=s.toCharArray();
        int i=n-1;
        if(ch[i]%2==0) return s;
        i--;
        StringBuilder sb=new StringBuilder();
        while(i>=0){
            if(ch[i]%2!=0) i--;
            else {
                while(i>=0){
                    sb.append(s.charAt(i));
                    i--;
                }
            }
        }
        return sb.reverse().toString();
        
    }
}
