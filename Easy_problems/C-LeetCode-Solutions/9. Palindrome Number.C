bool isPalindrome(int x) {
    if (x < 0) {
        return false;
    }

    int original = x;
    int reversed = 0;

    // Reverse the number
    while (x != 0) {
        int digit = x % 10; // Extract the last digit

        // Overflow check
        if (reversed > (INT_MAX - digit) / 10) {
            return false; // If overflow occurs, it's not a palindrome
        }

        reversed = reversed * 10 + digit; // Update the reversed number
        x = x / 10; // Remove the last digit
    }

    // Check if the reversed number is equal to the original
    return reversed == original;
}
