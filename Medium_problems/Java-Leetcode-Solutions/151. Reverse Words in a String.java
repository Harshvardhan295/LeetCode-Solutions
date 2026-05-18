class Solution {
    public String reverseWords(String s) {
        // .trim(): Removes spaces from the very beginning and very end of the string.
        // .split("\\s+"):
        // \\s is a regular expression for any whitespace (space, tab, newline).
        // + means "one or more."

        String[] arr = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();

        // Build the string in reverse
        for (int i = arr.length - 1; i >= 0; i--) {
            sb.append(arr[i]);
            if (i > 0) {
                sb.append(" ");
            }
        }
        
        return sb.toString();
    }
}
