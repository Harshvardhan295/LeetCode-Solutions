class Solution {
    public int smallestDivisor(int[] arr, int t) {
        int l = 1;
        int h = Integer.MIN_VALUE;

        for (int x : arr) h = Math.max(h, x);
        
        while (l <= h) {
            int mid = l + (h - l) / 2;

            if (isSmall(arr, t,mid)) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }

    boolean isSmall(int[] arr,int t,int mid){
        int res=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]%mid ==0) res+= arr[i]/mid;
            else{
                res+= (arr[i]+mid-1)/mid;
            }
        }
        return res<=t;
    }
}
