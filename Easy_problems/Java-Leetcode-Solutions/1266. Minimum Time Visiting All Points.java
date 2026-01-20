class Solution {
    public int minTimeToVisitAllPoints(int[][] p) {
        int ans=0;
        for(int i=1;i<p.length;i++){
            int x=p[i][0],y=p[i][1];
            int x_=p[i-1][0],y_=p[i-1][1];
            int diffx=Math.abs(x-x_),diffy=Math.abs(y-y_);
            ans+=Math.max(diffx,diffy);
        }
        return ans;
    }
}
