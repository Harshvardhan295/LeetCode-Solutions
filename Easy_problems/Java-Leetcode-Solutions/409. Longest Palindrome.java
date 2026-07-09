// Optimised
class Solution {
    public int longestPalindrome(String s) {
        int[] freq = new int[128];
        for(int i = 0; i < s.length(); i++){
            freq[s.charAt(i)]++; 
        }
        int ans = 0, k = 1;
        for(int i = 0; i < 128; i++){
            if((freq[i] % 2 != 0 && k > 0)) {
                k--;
                ans += freq[i];
            }
            else if(freq[i] % 2 == 0) ans += freq[i];
            else ans += freq[i] - 1;
        }
        return ans;
    }
}
// Simple
class Solution {
    public int longestPalindrome(String s) {
        int start=0,end=s.length()-1;
        HashMap<Character,Integer> mp=new HashMap<>();
        for(int i=0;i<s.length();i++){
            mp.put(s.charAt(i),mp.getOrDefault(s.charAt(i),0)+1);
        }
        int ans=0,k=1;
        for(char c:mp.keySet()){
            if((mp.get(c)%2!=0 && k>0)) {
                k--;
                ans+=mp.get(c);
            }
            else if(mp.get(c)%2==0) ans+=mp.get(c);
            else ans+=mp.get(c)-1;
        }
        return ans;
    }
}
