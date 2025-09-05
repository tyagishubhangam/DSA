class Solution {
    public int countServers(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int cnt = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    boolean row = false;
                    boolean column = false;
                    // row me check and column mei check
                    for(int k=0;k<n;k++){
                        if(k != i && grid[k][j] == 1){
                            row = true;
                            break;
                            
                        }
                        
                    }
                    for(int k=0;k<m;k++){
                        if(k != j && grid[i][k] == 1){
                            column = true;
                            break;
                        }
                    }
                    if(row || column){
                        cnt++;
                    }
                    
                }
            }
        }
        return cnt;
    }
}