class Solution {
    public boolean areNumbersAscending(String s) {
        int prev = 0;
        String[] words = s.split(" ");//bresks sentences into words
        for (String word : words) {
            if (Character.isDigit(word.charAt(0))) { 
                int num = Integer.parseInt(word); 
                if (num <= prev) return false; 
                prev = num;
            }
        }
        return true;
    }
}
