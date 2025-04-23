class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n];
        for(int i=0;i<n;i++){
            dp[i] = -1;
        }

        return jump(0,dp, n);
    }

    public static int jump(int i, int[] dp, int n){
        
        if(i > n){
            return 0;
        }
        if(i == n){
            return 1;
        }
        if(dp[i] != -1){
            return dp[i];
        }

        dp[i] = jump(i+1,dp, n) + jump(i+2, dp, n);

        return dp[i];
        
    }
}