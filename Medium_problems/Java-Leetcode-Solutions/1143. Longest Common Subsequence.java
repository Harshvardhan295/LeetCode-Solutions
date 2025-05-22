//Recursion
class Solution {
    public int longestCommonSubsequence(String a, String b) {
        int m=a.length(),n=b.length();
        if(m==0||n==0) return 0;
        String a2=a.substring(0,m-1);//does not includes m-1
        String b2=b.substring(0,n-1);//does not includes n-1
        if(a.charAt(m-1)==b.charAt(n-1)){
            return 1+longestCommonSubsequence(a2,b2);
        }
        else{
            int atake=longestCommonSubsequence(a2,b);
            int btake=longestCommonSubsequence(a,b2);
            return Math.max(atake,btake);
        }
    }
}
