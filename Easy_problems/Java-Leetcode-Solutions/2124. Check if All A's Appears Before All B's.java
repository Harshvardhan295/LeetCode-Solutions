class Solution {
    public boolean checkString(String s) {
        boolean flag=true;
        int countb=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='b'){
                countb++;
            }
            else{
                if(countb>0) return false;
            }
        }
        return true;
    }
}
