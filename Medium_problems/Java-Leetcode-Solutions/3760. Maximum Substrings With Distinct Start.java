class Solution {
    public int maxDistinct(String s) {
        int[] freq=new int[26];
        int ans=0;
        for(int i=0;i<s.length();i++){
            if(freq[s.charAt(i)-'a']==0)ans++;
            freq[s.charAt(i)-'a']++;
        }
        
        return ans;
    }
}
