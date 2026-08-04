class Solution {
    public boolean isValid(long sum, int x) {
        String s = String.valueOf(sum);
        int first = s.charAt(0) - '0';
        int second = s.charAt(s.length() - 1) - '0';
        return (first == x) && (second == x);
    }

    public int countValidSubarrays(int[] nums, int x) {
        int ans = 0;
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            long sum = 0; 
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (isValid(sum, x)) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
