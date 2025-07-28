class Solution {
    public static List<String> makeString(char[][] board) {
    List<String> result = new ArrayList<>();
    for (char[] row : board) {
        result.add(new String(row));
    }
    return result;
}

    public static boolean isSafe(char[][] board,int row,int col,int n){
        //for checking horizontal row
        for(int i=0;i<n;i++){
            if(board[row][i]=='Q') return false;
        }

        //for checking vertical row
        for(int i=0;i<n;i++){
            if(board[i][col]=='Q'){
                return false;
            }
        }

        //for checking left diagonal
        for(int i=row,j=col;i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }

        //for checking right diagonal
        for(int i=row,j=col;i>=0 && j<n;i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
    public static void queen (char[][] board, int row, List<List<String>> ans,int n){
        if(row==board.length){
            ans.add(makeString(board));
            return;
        }
        for(int col=0;col<board.length;col++){
            if(isSafe(board,row,col,n)){
                board[row][col]='Q';
                queen(board,row+1,ans,n);
                board[row][col]='.';
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        List<List<String>> ans=new ArrayList<>();
        queen(board,0,ans,n);
        return ans;
    }
}
