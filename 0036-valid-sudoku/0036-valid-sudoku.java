class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char num = board[i][j];
                if(Character.isDigit(num)){
                    for(int k=i+1;k<9;k++){
                        if(board[k][j] == num){
                            return false;
                        }
                    }
                    for(int l = j+1;l<9;l++){
                        if(board[i][l] == num){
                            return false;
                        }
                    }
                }
                if(i % 3 == 0 && j % 3 == 0){
                        int[] freq = new int[10];
                        for(int p=i;p<i+3;p++){
                            for(int q=j;q<j+3;q++){
                                char ch = board[p][q];
                                if(Character.isDigit(ch)){
                                    if(freq[ch-'0'] > 0){
                                        return false;
                                    }
                                    freq[ch-'0']++;
                                }
                            }
                        }
                    }
                
            }
        }
        return true;
    }
}



// [
//     [".",".",".",".","5",".",".","1","."],
//     [".","4",".","3",".",".",".",".","."],
//     [".",".",".",".",".","3",".",".","1"],
//     ["8",".",".",".",".",".",".","2","."],
//     [".",".","2",".","7",".",".",".","."],
//     [".","1","5",".",".",".",".",".","."],
//     [".",".",".",".",".","2",".",".","."],
//     [".","2",".","9",".",".",".",".","."],
//     [".",".","4",".",".",".",".",".","."]
// ]