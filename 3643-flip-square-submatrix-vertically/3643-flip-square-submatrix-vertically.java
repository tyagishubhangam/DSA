class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        for(int i=y;i<y+k;i++){
            int top = x;
            int bottom = x + k - 1;
            while(top < bottom){
                int tmp = grid[top][i];
                grid[top][i] = grid[bottom][i];
                grid[bottom][i] = tmp;
                bottom--;
                top++;
            }
        }

        return grid;
    }
}