//My solution
class Solution {
    public long countCommas(long n) {
        long[] arr = { 1000L, 1000000L, 1000000000L, 1000000000000L, 1000000000000000L };
        long ans = 0;
        int idx = 0;
        while (idx < 5 && n >= arr[idx]) {
            ans += n - arr[idx++] + 1;
        }
        return ans;
    }
}
// More optimal
class Solution {
    public long countCommas(long n) {
        long ans=0;
        long base=1000;
        while(base<=n){
            ans+=n-base+1;
            base*=1000;
        }
        return ans;
    }
}
