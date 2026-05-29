class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int m=image.length;
        int n=image[0].length;
        int[][] ans=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=n-1;j>=0;j--){
                if(image[i][j]==0)ans[i][Math.abs(j-(n-1))]=1;
                else ans[i][Math.abs(j-(n-1))]=0;
            }
        }
        return ans;
    }
}
