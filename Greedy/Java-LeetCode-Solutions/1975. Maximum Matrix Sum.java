class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long min=Long.MAX_VALUE;
        int cnt=0;
        long sum=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]<0) cnt++;
                sum+=Math.abs(matrix[i][j]);
                min=Math.min(min,Math.abs(matrix[i][j]));
            }
        }
        return (cnt%2==0) ? sum : sum-2*min;
    }
}
