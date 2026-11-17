class Solution {
    public int minPenalty(int p, int[] l, int[] arr) {
        int n=arr.length;
        for(int i=0;i<n;i++){
            arr[i]= arr[i]%p;
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<l.length;i++){
            max=Math.max(l[i],max);
        }
        int ans=0;
        for(int i=0;i<n;i++){
            if(arr[i]>=max){
                ans=Math.max(ans,p-arr[i]);
            }
        }
        return ans;
    }
}
