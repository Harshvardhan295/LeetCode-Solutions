class Solution {
    public int findNumbers(int[] arr) {
        int ans=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<10) continue;
            if(arr[i]<100) {
                ans++;
                continue;
            }
            if(arr[i]<1000) continue;
            if(arr[i]<10000) {
                ans++;
                continue;
            }
            if(arr[i]<100000) continue;
            if(arr[i]==100000) {
                ans++;
                continue;
            }
        }
        return ans;
    }
}
