// Straigth forward solution
class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1){//edge case
            return Integer.MAX_VALUE; 
        }
        return dividend / divisor;
    }
}
