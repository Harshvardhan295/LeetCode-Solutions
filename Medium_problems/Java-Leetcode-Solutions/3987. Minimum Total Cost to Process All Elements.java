class Solution {
    public int minimumCost(int[] arr, int k) {
        long totalK = k;
        long totalRefills = 0;
        long MOD = 1000000007;

        for (int i = 0; i < arr.length; i++) {            
            int x = arr[i]; 

            if (totalK < x) {
                long deficit = x - totalK;
                long requiredRefills = (deficit + k - 1) / k; //uppercase
                
                totalRefills += requiredRefills;
                totalK += requiredRefills * k;
            }
            totalK -= x;
        }

        long n = totalRefills % MOD;
        long ans = (n * (n + 1) / 2) % MOD;

        return (int) ans;
    }
}
