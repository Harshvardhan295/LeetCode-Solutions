//Sorting
class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String s1 = strs[0];
        String s2 = strs[strs.length-1];
        System.out.println(s1);
        System.out.println(s2);
        int idx = 0;
        while(idx < s1.length() && idx < s2.length()){
            if(s1.charAt(idx) == s2.charAt(idx)){
                idx++;
            } else {
                break;
            }
        }
        return s1.substring(0, idx);
    }
}
//Prefix
class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        int prefixLen = prefix.length();

        for (int i = 1; i < strs.length; i++) {
            String s = strs[i];
            while (prefixLen > s.length() || !prefix.equals(s.substring(0, prefixLen))) {
                prefixLen--;
                if (prefixLen == 0) {
                    return "";
                }
                prefix = prefix.substring(0, prefixLen);
            }
        }

        return prefix;        
    }
}
