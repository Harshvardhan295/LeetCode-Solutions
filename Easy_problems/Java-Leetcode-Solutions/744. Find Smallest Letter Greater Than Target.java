class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        char first=letters[0];
        for(int i=0;i<letters.length;i++){
            if(letters[i]==target) continue;
            else if( letters[i]-'a'>target-'a') {
                first=letters[i];
                break;
            }
        }
        return first;
    }
}
