class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        boolean[][] dp = new boolean[arr.length + 1][sum + 1];
        for(int i=0;i<=arr.length;i++){
            for(int j=0;j<=sum;j++){
                if(j == 0){
                    dp[i][j] = true;
                    continue;
                }
                dp[i][j] = false;
            }
        }
        return recurse(arr,arr.length,sum,dp);
        
    }
    
    public static boolean recurse(int[] arr, int n, int sum,boolean[][] dp){
        if(sum == 0){
            return true;
        }
        if(n == 0){
            return false;
        }
        
        if(dp[n][sum]){
            return true;
        }
        
        if(arr[n-1] <= sum){
            return dp[n][sum] = recurse(arr,n-1, sum - arr[n-1],dp) || recurse(arr,n-1,sum,dp);
        }
        return dp[n][sum] = recurse(arr, n-1, sum,dp);
    }
}