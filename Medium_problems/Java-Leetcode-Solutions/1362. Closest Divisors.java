class Solution {
    public int[] closestDivisors(int num) {
        int[] res1 = getDivisors(num + 1);
        int[] res2 = getDivisors(num + 2);
        
        if (Math.abs(res1[0] - res1[1]) < Math.abs(res2[0] - res2[1])) {
            return res1;
        }
        return res2;
    }
    
    private int[] getDivisors(int target) {
        // Iterate downward from the square root floor. 
        // The first divisor found is guaranteed to be the largest possible smaller factor, 
        // which automatically minimizes the absolute difference between the two factors.
        for (int i = (int) Math.sqrt(target); i >= 1; i--) {
            if (target % i == 0) {
                return new int[]{i, target / i};
            }
        }
        return new int[]{1, target};
    }
}
