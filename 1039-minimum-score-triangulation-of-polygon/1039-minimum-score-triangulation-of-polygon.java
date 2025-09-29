class Solution {
    public int minScoreTriangulation(int[] values) {
        int[][] dp = new int[51][51];
        for(int i=0;i<51;i++){
            Arrays.fill(dp[i], -1);
        }
        return recurse(values, 0,values.length-1, dp);
    }

    public int recurse(int[] values, int i, int j, int[][] dp){
        if(j - i + 1< 3){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int res = Integer.MAX_VALUE;

        for(int k = i+1;k<j;k++){
            int wt = recurse(values, i,k, dp) + (values[i] * values[k] * values[j]) + recurse(values, k,j, dp);

            res = Math.min(res, wt);
        }

        return dp[i][j] = res;
    }
}