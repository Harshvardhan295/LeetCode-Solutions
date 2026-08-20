class Solution {
    public int maxProduct(int n) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int[] freq = new int[10];

        while (n > 0) {
            int d = n % 10;
            freq[d]++;
            n/=10;
        }

        for (int i = 9; i >= 0; i--) {
            if (freq[i] > 1){
                if(i<max1) {
                    max2=i;
                    break;
                }
                else return i * i;
            }
            else if(freq[i]==1) {
                if (max1 == Integer.MIN_VALUE)
                    max1 = i;
                else {
                    max2 = i;
                    break;
                }
            }
        }
        return max1 * max2;
    }
}
