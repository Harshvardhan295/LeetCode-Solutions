class Solution {
    public String reverseByType(String str) {
        int n=str.length();
        List<Character> l=new ArrayList<>();
        List<Character> s=new ArrayList<>();
        boolean[] isLetter=new boolean[n];
        for(int i=0;i<n;i++){
            char ch=str.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                l.add(ch);
                isLetter[i]=true;
            }
            else s.add(ch);
        }
        Collections.reverse(l);
        Collections.reverse(s);
        int a=0,b=0;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            if(isLetter[i]) sb.append(l.get(a++));
            else sb.append(s.get(b++));
        }
        return sb.toString();
    }
}
