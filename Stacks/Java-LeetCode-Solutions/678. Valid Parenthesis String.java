// Simple optimised
class Solution {
    public boolean checkValidString(String s) {
        int minBrackets = 0;
        int maxBrackets = 0;

        for(char ch : s.toCharArray()){
            if(ch == '('){
                minBrackets++;
                maxBrackets++;
            }else if(ch == '*'){
                minBrackets = Math.max(minBrackets - 1, 0);
                maxBrackets++;
            }else{
                minBrackets = Math.max(minBrackets - 1, 0);
                maxBrackets--;
            }

            if(maxBrackets < 0) return false;
        }

        if(minBrackets == 0) return true;

        return false;
    }
}
// Stack solution
class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer>  bracketsStack = new Stack<>();
        Stack<Integer> asteriskStack = new Stack<>();
        char [] sArr = s.toCharArray(); 
        for(int i=0;i<sArr.length;i++){
            char ch = sArr[i];

            if(ch == '(')
                bracketsStack.push(i);
            else if(ch=='*') 
                asteriskStack.push(i);
            else if(!bracketsStack.isEmpty())
                bracketsStack.pop();
            else if(!asteriskStack.isEmpty())
                asteriskStack.pop();
            else
                return false;
        }

        while(!bracketsStack.isEmpty() && !asteriskStack.isEmpty() && bracketsStack.peek()<asteriskStack.peek()){
            bracketsStack.pop();
            asteriskStack.pop();
        }

        return bracketsStack.isEmpty();
    }
}
