class Solution {
    public int reverse(int x) {
        int num = Math.abs(x); //Eliminates the negative sign
        
        int reverse = 0;  
        
        while (num != 0) {
            int digit = num % 10;  // Last digit 
            
            // Overflow check
            if (reverse > (Integer.MAX_VALUE - digit) / 10) {
                return 0;  
            }
            
            reverse = reverse * 10 + digit;  
            num = num / 10; 
        }
        return (x < 0) ? (-reverse) : reverse;  
    }
}
