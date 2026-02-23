class Solution {
    public boolean isDigitorialPermutation(int n) {
        if (n == 0)
            return false;

        int x = n;
        int sum = 0;
        int[] freq = new int[10];
        int[] fact = new int[10];
        fact[0] = 1;

        for (int i = 1; i <= 9; i++) {
            fact[i] = fact[i - 1] * i;
        }

        while (x != 0) {
            int digit = x % 10;
            freq[digit]++;
            sum += fact[digit];
            x /= 10;
        }

        if (sum == n)
            return true;

        x = sum;
        while (x != 0) {
            int digit = x % 10;
            freq[digit]--;
            if (freq[digit] < 0)
                return false;
            x /= 10;
        }

        for (int i = 0; i < 10; i++) {
            if (freq[i] != 0)
                return false;
        }

        return true;
    }
}
