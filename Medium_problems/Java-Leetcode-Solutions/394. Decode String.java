class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;

        for (char c : s.toCharArray()) {

            if (Character.isDigit(c)) {
                // Building the number k
                k = k * 10 + (c - '0');
            } 
            
            else if (c == '[') {
                countStack.push(k);  // Push current k
                stringStack.push(currentString);//(for case:"[a[b]]" we append till "[a" )
                k = 0;  // Reset for new segment
                currentString = new StringBuilder();
            } 
            
            else if (c == ']') {
                int repeatTimes = countStack.pop();//pop the number
                StringBuilder decodedString = stringStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    decodedString.append(currentString);
                }
                currentString = decodedString;
            } 
            
            else {
                currentString.append(c);
            }
        }

        return currentString.toString();
    }
}
