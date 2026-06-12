class Solution {
    public int getMinDistance(int[] arr, int t, int s) {
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            if(t==arr[i]){
                int a=Math.abs(i-s);
                ans=Math.min(ans,a);
            }
        }
        return ans;
    }
}
