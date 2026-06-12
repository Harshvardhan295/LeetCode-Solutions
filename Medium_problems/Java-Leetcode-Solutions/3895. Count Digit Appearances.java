class Solution {
    public int check(int n, int digit){
        int cnt=0;
        while(n!=0){
            int d=n%10;
            if(d==digit) cnt++;
            n/=10;
        }
        return cnt;
    }
    public int countDigitOccurrences(int[] arr, int digit) {
        int n=arr.length;
        int ans=0;
        for(int i=0;i<n;i++){
            ans+=check(arr[i],digit);
        }
        return ans;
    }
}
