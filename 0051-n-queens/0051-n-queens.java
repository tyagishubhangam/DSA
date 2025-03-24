class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> li = new ArrayList<>();
        char[][] arr = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = '.';
            }
        }

        generateAns(0,n,arr,li);
        return li;
    }

    public static void generateAns(int row, int n, char[][] arr,List<List<String>> li){
        if(row == n){
            List<String> tmp = new ArrayList<>();
            for(int x = 0;x<n;x++){
                String str = "";
                for(char ch:arr[x]){
                    str += ch;
                }
                tmp.add(str);
            }
            li.add(tmp);
            return;
        }

        for(int col = 0;col<n;col++){
            if(isSafe(row,col,arr)){
                arr[row][col] = 'Q';
                generateAns(row+1,n,arr,li);
                arr[row][col] = '.';
            }

        }
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
}