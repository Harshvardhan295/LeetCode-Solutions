bool isPalindrome(int x) {
    if (x < 0) {
        return false;
    }

    int original = x;
    int reversed = 0;

    while (x != 0) {
        int digit = x % 10; 

        // Overflow check
        if (reversed > (INT_MAX - digit) / 10) {
            return false; // If overflow occurs, it's not a palindrome
        }

        reversed = reversed * 10 + digit; 
        x = x / 10; 

    return reversed == original;
}
