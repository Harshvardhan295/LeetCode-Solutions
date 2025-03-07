//PrefixSum
class Solution {
    public int bestClosingTime(String s) {
        int n = s.length();
        int[] preN = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preN[i] = preN[i - 1];
            if (s.charAt(i - 1) == 'N')
                preN[i] += 1;
        }
        int[] sufY = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            sufY[i] = sufY[i + 1];
            if (s.charAt(i) == 'Y')
                sufY[i] += 1;
        }
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            preN[i] += sufY[i];
            min = Math.min(preN[i], min);
        }
        for(int i=0;i<=n;i++){
            if(preN[i]==min) return i;
        }
        return -1;
    }
}
//Brute Force
class Solution {
    public int bestClosingTime(String s) {
        int n = s.length();
        int minPenalty = Integer.MAX_VALUE;
        int bestTime = 0;

        // Iterate through each possible closing time
        for (int i = 0; i <= n; i++) {
            int penalty = 0;

            // Count 'N's before index i
            for (int j = 0; j < i; j++) {
                if (s.charAt(j) == 'N') {
                    penalty++;
                }
            }

            // Count 'Y's after index i
            for (int j = i; j < n; j++) {
                if (s.charAt(j) == 'Y') {
                    penalty++;
                }
            }

            // Update the minimum penalty and best time
            if (penalty < minPenalty) {
                minPenalty = penalty;
                bestTime = i;
            }
        }

        return bestTime;
    }
}

