class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int idx=0,totalones=0;
        for(int i=0;i<mat.length;i++){
            int ones=0;
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==1) ones++;

            }
            if(ones>totalones){
                idx=i;
                totalones=ones;
            }
        }
        return new int[]{idx,totalones};
    }
}
