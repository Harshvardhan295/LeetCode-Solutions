//--------------------Optimised solution-----------------------
class Solution {
    public void reverseString(char[] s) {
        int n = s.length; 
        
        for (int i = 0; i < n / 2; i++) {//n/2 ensures that half right swaps half left elements
            //Swap
            char temp = s[i]; 
            s[i] = s[n - 1 - i];
            s[n - 1 - i] = temp;
        }
    }
}
//---------------Brute Force---------------------
class Solution {
    public void reverseString(char[] s) {
        int n = s.length; 
        char[] reversed = new char[n]; 
        
        for (int i = 0; i < n; i++) {
            reversed[i] = s[n - 1 - i]; 
        }
        
        for (int i = 0; i < n; i++) {
            s[i] = reversed[i];
        }
    }
}
