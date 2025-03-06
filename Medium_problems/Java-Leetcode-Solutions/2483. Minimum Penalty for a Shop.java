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
