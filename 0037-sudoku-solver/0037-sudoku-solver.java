class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
        
    }
    public boolean solve(char[][] board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j] == '.'){
                    for(char ch = '1';ch<='9';ch++){
                        
                        if(isValid(board, ch,i,j)){
                            board[i][j] = ch;
                            if(solve(board)){
                                return true;
                            }
                            board[i][j] = '.';
                            
                        }
                        
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValid(char[][] board, char curr, int row, int col){
        for(int i=0;i<9;i++){
            // for check full row
            if(board[i][col] == curr){
                return false;
            }
            // for checking full column
            if(board[row][i] == curr){
                return false;
            }
        }
            // now we will check for the box
            int currRow = row - row%3;
            int currCol = col - col%3;
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    if(board[i+currRow][j+currCol] == curr){
                        return false;
                    }
                }
            }

            return true;
        
    }
}