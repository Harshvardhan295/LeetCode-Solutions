class Solution {
    static final int n = 100004;
    static int[] sieve = new int[n];

    static {
        sieve[0] = sieve[1] = 1;

        for (int i = 2; i <= 316; i++)
            if (sieve[i] == 0)
                for (int j = i * i; j < n; j += i)
                    sieve[j] = 1;
    }

    public int minOperations(int[] nums) {
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            int j = nums[i];

            if ((i & 1) == 1)
                while (sieve[j++] == 0)
                    res++;
            else
                while (sieve[j++] == 1)
                    res++;
        }

        return res;
    }
}
