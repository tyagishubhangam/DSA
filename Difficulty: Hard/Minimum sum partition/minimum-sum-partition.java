// User function Template for Java

class Solution {

    public int minDifference(int arr[]) {
        // Your code goes here
        int n = arr.length;
        int range =0;
        for(int i=0;i<n;i++){
            range += arr[i];
        }
        boolean[] valid = new boolean[range+1];
        valid[0] = true;
        Boolean[][] dp = new Boolean[n+1][range+1];
        
        for(int i=0;i<=range;i++){
            valid[i] = subsetsum(arr,n,i,dp);
        }
        int res = (int)1e9;
        for(int j=range/2;j>=0;j--){
            if(valid[j]){
                res = Math.min(res,range - 2*j);
                break;
            }
        }
        
        return res;
    }
    
    public static boolean subsetsum(int[] arr, int n, int s, Boolean[][] dp){
        if(s == 0){
            return true;
        }
        if(n == 0){
            return false;
        }
        
        if(dp[n][s] != null){
            return dp[n][s];
        }
        if(arr[n-1] <= s){
            return dp[n][s] = subsetsum(arr,n-1,s-arr[n-1],dp) || subsetsum(arr, n-1, s,dp);
        }else{
            if(arr[n-1] > s){
                dp[n][s] = subsetsum(arr,n-1,s,dp);
            }
        }
        return dp[n][s];
        
    }
}
