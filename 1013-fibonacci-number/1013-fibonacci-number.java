class Solution {
    public int fib(int n) {
        int[] dp = new int[n+1];
        for(int i=0;i<=n;i++){
            dp[i] = -1;
        }

        return getnum(n, dp);
    }

    public static int getnum(int n, int[] dp){
        if(dp[n] != -1){
            return dp[n];
        }

        if(n<2){
            return n;
        }

        return dp[n] = getnum(n - 1, dp) + getnum(n-2, dp);
    }
}