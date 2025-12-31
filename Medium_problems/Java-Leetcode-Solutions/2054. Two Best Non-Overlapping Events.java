class Solution {
    public int maxTwoEvents(int[][] events) {
        int n=events.length;
        int[][] start=Arrays.copyOf(events,n);
        int[][] end=Arrays.copyOf(events,n);
        Arrays.sort(start,(a,b)->a[0]-b[0]);
        Arrays.sort(end,(a,b)->a[1]-b[1]);

        int max=0,ans=Integer.MIN_VALUE;
        int j=0;
        for(int i=0;i<events.length;i++){
            int stime=start[i][0],etime=start[i][1],curval=start[i][2];
            while(j<n && end[j][1]<stime){
                max=Math.max(max,end[j][2]);
                j++;
            }
            ans=Math.max(ans,max+curval);
        }
        return ans;
    }
}
