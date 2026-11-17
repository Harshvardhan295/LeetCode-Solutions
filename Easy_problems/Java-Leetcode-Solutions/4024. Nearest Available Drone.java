class Solution {
    public int nearestDrone(int[][] arr, int[] t) {
        int m=arr.length;
        int min=Integer.MAX_VALUE,idx=-1;
        for(int i=0;i<m;i++){
            int a=arr[i][0];
            int b=arr[i][1];
            int c=arr[i][2];
            int dist= Math.abs(a-t[0]) + Math.abs(b-t[1]);
            if(dist<=c && dist<min){
                min=dist;
                idx=i;
            }
        }
        return idx;
    }
}
