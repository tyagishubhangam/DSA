class Solution {
    public int fib(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return recurse(n, dp);
    }

    public int recurse(int i, int[] dp){
        if(i <= 1){
            return i;
        }
        if(dp[i] != -1){
            return dp[i];
        }

        return dp[i] = recurse(i-1, dp) + recurse(i-2, dp);
    }
}