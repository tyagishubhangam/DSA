class Solution {
    public int lenOfVDiagonal(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dirs = {{1,1}, {1,-1}, {-1,-1}, {-1,1}}; 
        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    // now hum move karnge 
                    for(int d=0;d<4;d++){
                        ans = Math.max(ans, 1+move(i,j,d,grid, dirs, true,2));
                    }
                    
                }
            }
        }
        return ans;
    }
    public int move(int i, int j, int d, int[][] grid, int[][] dirs, boolean canTurn, int nxt){
        int n_i = i + dirs[d][0];
        int n_j = j + dirs[d][1];
        if(n_i < 0 || n_j < 0 || n_i >= grid.length || n_j >= grid[0].length || grid[n_i][n_j] != nxt){
            return 0;
        }
        int turned = 0;
        int samePath = 1 + move(n_i, n_j, d, grid, dirs, canTurn, nxt == 2 ? 0 : 2);
    
        
        if(canTurn){
            
            turned = 1+move(n_i,n_j,(d+1)%4, grid, dirs, false, nxt == 2 ? 0 : 2);
           
            
        }
     return Math.max(samePath, turned);
     }

}    