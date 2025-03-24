class Solution {
    

    public static int generateAns(int row, int n, char[][] arr){
        if(row == n){
           
           return 1;
        }
        int ans = 0;
        for(int col = 0;col<n;col++){
            if(isSafe(row,col,arr)){
                arr[row][col] = 'Q';
                ans +=generateAns(row+1,n,arr);
                arr[row][col] = '.';
            }

        }
        return ans;
    }

    public static boolean isSafe(int row, int col, char[][] arr){
        int x = row - 1;
        while(x>=0){
            if(arr[x][col] == 'Q'){
                return false;
            }
            x--;
        }
        
        x = row - 1;
       int y = col - 1;
        while(x >= 0 && y >= 0){
            if(arr[x][y] == 'Q'){
                return false;
            }
            x--;
            y--;
        }

        x = row - 1;
        y = col + 1;
        while(x>= 0 && y < arr.length){
            if(arr[x][y] == 'Q'){
                return false;
            }
            x--;
            y++;
        }
        return true;
    }
    public int totalNQueens(int n) {
         char[][] arr = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = '.';
            }
        }
       return generateAns(0,n,arr);
        // return count;
    }


}