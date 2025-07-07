class Solution {
    static int matrixMultiplication(int arr[]) {
        // code here
        int n = arr.length;
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i], -1);
        }
        
        return recurse(arr,1,n-1,dp);
        
    }
    public static int recurse(int[] arr, int i, int j, int[][] dp){
        if(i >= j){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int res = Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int tmp = recurse(arr, i, k,dp) + recurse(arr,k+1, j, dp) + arr[i-1] * arr[k] * arr[j];
            if(res > tmp){
                res = tmp;
            }
        }
        
        return dp[i][j] = res;
    }
}