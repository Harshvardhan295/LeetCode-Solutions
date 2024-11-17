class Solution {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }

        boolean[] isPrime = new boolean[n];
        //assume all numbers are prime
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }

        // mark all multiples of i as false
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {//if its square lies in range less than n then it is not prime
                    isPrime[j] = false;
                }
            }
        }

        // Count the remaining as prime numbers
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }

        return count;
    }
}
