class Solution {
    public String countAndSay(int n) {
        if (n <= 0) return "";
        
        String result = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder current = new StringBuilder();
            int count = 1;
            char say = result.charAt(0);
            
            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j) == say) {
                    count++;
                } else {
                    current.append(count).append(say);
                    say = result.charAt(j);
                    count = 1;
                }
            }
            current.append(count).append(say);  // Append the last counted sequence
            result = current.toString();
        }
        
        return result;
    }
}

