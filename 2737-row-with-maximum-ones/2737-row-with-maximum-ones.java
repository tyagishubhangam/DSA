class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;
        int ans[] = new int[2];
        int maxSum = 0;
        for(int i=0;i<r;i++){
            int rowSum = 0;
            for(int j=0;j<c;j++){
                rowSum += mat[i][j];
            }
            if(rowSum > 0 && rowSum > maxSum){
                maxSum = rowSum;
                ans[0] = i;
                ans[1] = maxSum;
            }
        }
        
        return ans;
    }
}