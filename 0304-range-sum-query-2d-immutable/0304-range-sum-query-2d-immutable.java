class NumMatrix {
    int preComp[][];
    public NumMatrix(int[][] matrix) {
        preComp = new int[matrix.length][matrix[0].length];
        preComp[0][0] = matrix[0][0];
        for(int i=0;i<matrix.length;i++){
            preComp[i][0] = matrix[i][0];
            for(int j=1;j<matrix[0].length;j++){
                preComp[i][j] = preComp[i][j-1] + matrix[i][j];
            }
        }
        for(int j=0;j<matrix[0].length;j++){
            for(int i=1;i<matrix.length;i++){
                preComp[i][j] = preComp[i-1][j] + preComp[i][j];
            }
        }
        
        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
            int res = preComp[row2][col2];
            if((col1 -1) >=0){
                res -= preComp[row2][col1 - 1];
            }
            if((row1 - 1) >= 0){
                res -= preComp[row1 - 1][col2];
            }
            if((row1 -1) >= 0 && (col1 - 1) >= 0){
                res += preComp[row1 - 1][col1 - 1];
            }

            return res;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */