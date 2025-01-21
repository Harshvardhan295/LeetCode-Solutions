class Solution {
    public static String reverseString(String x) {
        StringBuilder s= new StringBuilder(x);
        s.reverse();
        return s.toString();
    }

    public int maximumNumberOfStringPairs(String[] words) {
        HashSet<String> set = new HashSet<>();
        int count=0;
        for (String ele : words) {
            if(set.contains(reverseString(ele))){
                count++;
            }
            else set.add(ele);
        }
        return count;
    }
}
