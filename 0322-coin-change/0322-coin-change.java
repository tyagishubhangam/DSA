class Solution {
    public int coinChange(int[] coins, int amount) {
        long[] dp = new long[amount + 1];
        Arrays.fill(dp, -1);
        long res = getMinCoins(amount, coins,dp);
        if(res >= Integer.MAX_VALUE){
            return -1;
        }

        return (int)res;
    }

    public static long getMinCoins(int amt, int[] coins,long[] dp){
        if(amt == 0){
            return 0;
        }
        if(amt < 0){
            return Integer.MAX_VALUE;
        }
        if(dp[amt] != -1){
            return dp[amt];
        }
        long ans = Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++){
            ans = Math.min(ans, 1+getMinCoins(amt - coins[i], coins, dp));
        }

        return dp[amt] = ans;
    }
}