class Solution {
    public int maxDistance(int[] colors) {
        int n=colors.length-1;
        int ans=-1;
        for(int i=n;i>=0;i--){
            if(colors[0]!=colors[i]) {
                ans=i;
                break;
            }
        }
        for(int i=0;i<=n;i++){
            if(colors[n]!=colors[i]) {
                ans=Math.max(ans,n-i);
                return ans;
            }
        }
        return -1;
    }
}
