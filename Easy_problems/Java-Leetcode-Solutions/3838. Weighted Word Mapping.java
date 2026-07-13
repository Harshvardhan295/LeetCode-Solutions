// Method 1
class Solution {
    public String mapWordWeights(String[] words, int[] w) {
        StringBuilder ans = new StringBuilder();
        
        char[] alpha = {
            'a','b','c','d','e','f','g','h','i','j',
            'k','l','m','n','o','p','q','r','s','t',
            'u','v','w','x','y','z'
        };

        for (int i = 0; i < words.length; i++) {
            int sum = 0;
            
            for (char c : words[i].toCharArray()) {
                sum += w[c - 'a'];
            }
            
            sum = sum % 26;
            
            ans.append(alpha[25 - sum]);
        }
        
        return ans.toString();
    }
}

// Optimised Solution
class Solution {
    public String mapWordWeights(String[] words, int[] w) {
        String ans="";
        for(int i=0;i<words.length;i++){
            String s=words[i];
            int sum=0;
            for(char ch: s.toCharArray()){
                sum+=w[ch-'a'];
            }
            sum=sum%26;
            ans+=(char)('z'-sum);
        }
        return ans;
    }
}
