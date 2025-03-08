class Solution {
    public int uniquePaths(int m, int n) {
        int[][] paths = new int[101][101];
        return countPaths(0,0,m,n,paths);
    }

    public int countPaths(int i, int j,int m, int n,int[][] paths){
        if(i == m-1 || j == n-1){
            return 1;
        }
        if(paths[i][j] != 0){
            return paths[i][j];
        }
        paths[i][j] = countPaths(i,j+1,m,n,paths) + countPaths(i+1,j,m,n,paths);
        return paths[i][j];
        
    }
}