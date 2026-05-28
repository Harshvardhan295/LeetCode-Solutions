// Straigth forward solution
class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1){//edge case
            return Integer.MAX_VALUE; 
        }
        return dividend / divisor;
    }
}
// Bit manipulation
class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1)//edge case
            return Integer.MAX_VALUE;

        boolean negative = (dividend < 0) ^ (divisor < 0); //Logical XOR will help in deciding if the results is negative only if any one of them is negative

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int quotient = 0, subQuot = 0;

        while (dividend - divisor >= 0) {
            for (subQuot = 0; dividend - (divisor << subQuot << 1) >= 0; subQuot++);
            quotient += 1 << subQuot; //Add to the quotient
            dividend -= divisor << subQuot; //Substract from dividend to start over with the remaining
        }

        //same above logic but simple to understand
        // while (dividend >= divisor) {
        //     int temp = divisor;
        //     int count = 1;

        //     while (dividend >= temp * 2) {
        //         temp *= 2;
        //         count *= 2;
        //     }

        //     dividend -= temp;
        //     quotient += count;
        // }
        return negative ? -quotient : quotient;
    }
}
