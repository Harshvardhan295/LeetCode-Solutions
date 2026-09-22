class Solution {
    private static final int MOD = 1000000007;

    private void getPrimes(int[] nums, Set<Integer> primes) {
        for (int ele : nums) {
            for (int i = 2; i * i <= ele; i++) {
                if (ele % i == 0) {
                    primes.add(i);
                    while (ele % i == 0) {
                        ele /= i;
                    }
                }
            }
            if (ele > 1) {
                primes.add(ele);
            }
        }
    }

    private int kadanesAlgoScore(int[] nums, int prime) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        
        for (int num : nums) {
            if (num % prime == 0) {
                currSum += num;
            } else {
                currSum -= num;
            }

            maxSum = Math.max(maxSum, currSum);
            if (currSum < 0) {
                currSum = 0;
            }
        }
        return maxSum;
    }

    public int divisibleGame(int[] nums) {
        // Step-1: Get all primes which can divide any nums[i]
        // TreeSet maintains the ascending order required for correct tie-breaking
        Set<Integer> primes = new TreeSet<>();
        getPrimes(nums, primes);
        
        if (primes.isEmpty()) {
            primes.add(2);
        }

        // Step-2: Get smallest prime with highest score
        int maxScore = Integer.MIN_VALUE;
        int k = -1;
        
        for (int prime : primes) {
            int currScore = kadanesAlgoScore(nums, prime);
            if (maxScore < currScore) {
                maxScore = currScore;
                k = prime;
            }
        }
        
        // Handle negative modulo correctly in Java
        long ans = ((long) maxScore % MOD * k) % MOD;
        return (int) ((ans + MOD) % MOD);
    }
}
