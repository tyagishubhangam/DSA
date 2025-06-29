class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return recurse(n,dp);
    }

    public static int recurse(int i, int[] dp){
        if(i<0){
            return 0;
        }
        if(i == 0){
            return 1;
        }
        if(dp[i] != -1){
            return dp[i];
        }

        dp[i] = recurse(i-1,dp) + recurse(i-2,dp);
        return dp[i];
    }
}