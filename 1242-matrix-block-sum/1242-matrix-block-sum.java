class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] preSumMatrix = new int[m][n];
        preSumMatrix[0][0] = mat[0][0];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(j == 0){
                    preSumMatrix[i][j] = mat[i][j];
                }else{
                    preSumMatrix[i][j] = preSumMatrix[i][j-1] + mat[i][j];
                }
                
            }
        }

        for(int i=1;i<m;i++){
            for(int j=0;j<n;j++){
                preSumMatrix[i][j] += preSumMatrix[i-1][j];
            }
        }

        int[][] ans = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int minRow = Math.max(0, i-k);
                int maxRow = Math.min(i+k, m - 1);
                int minColumn = Math.max(0, j - k);
                int maxColumn = Math.min(j + k, n - 1);

                ans[i][j] = preSumMatrix[maxRow][maxColumn];

                if(minRow - 1 >=0){
                    ans[i][j] -= preSumMatrix[minRow - 1][maxColumn];
                }

                if(minColumn - 1 >= 0){
                    ans[i][j] -= preSumMatrix[maxRow][minColumn - 1];
                }

                if(minColumn -1 >= 0 && minRow - 1 >= 0){
                    ans[i][j] += preSumMatrix[minRow - 1][minColumn - 1];
                }
            }
        }
    

        // for(int i=0;i<m;i++){
        //     for(int j=0;j<n;j++){
        //         System.out.print(ans[i][j]+" ");
        //     }
        //     System.out.println("");
        // }

        return ans;
    }
}