//Recursion
class Solution {
    public static int mcm(int i,int j,int[] arr){
        if(i>j) return 0;
        int minCost=Integer.MAX_VALUE;
        for(int k=i;k<=j;k++){
            int len=arr[j+1]-arr[i-1];
            int totalCost=mcm(i,k-1,arr)+mcm(k+1,j,arr)+len;
            minCost=Math.min(minCost,totalCost);
        }
        return minCost;
    }
    public int minCost(int n, int[] cuts) {
        int[] arr= new int[cuts.length+2];
        int i;
        for(i=0;i<cuts.length;i++){
            arr[i]= cuts[i];
        }
        arr[i++]= 0;
        arr[i]=n;
        Arrays.sort(arr);
        return mcm(1, arr.length-2,arr);
    }
}
//Memoization
class Solution {
    public static int mcm(int i,int j,int[] arr,int[][] dp){
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int minCost=Integer.MAX_VALUE;
        for(int k=i;k<=j;k++){
            int len=arr[j+1]-arr[i-1];
            int totalCost=mcm(i,k-1,arr,dp)+mcm(k+1,j,arr,dp)+len;
            minCost=Math.min(minCost,totalCost);
        }
        return dp[i][j]=minCost;
    }
    public int minCost(int n, int[] cuts) {
        int[] arr= new int[cuts.length+2];
        int i;
        for(i=0;i<cuts.length;i++){
            arr[i]= cuts[i];
        }
        arr[i++]= 0;
        arr[i]=n;
        Arrays.sort(arr);
        //i=1 to m-2 && j=m-2 to 1
        int m=arr.length;
        int[][] dp=new int[m-1][m-1];
        for(i=0;i<m-1;i++){
            for(int j=0;j<m-1;j++) {
                dp[i][j]=-1;
            }
        }
        return mcm(1, m-2,arr,dp);
    }
}
