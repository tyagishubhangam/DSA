class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1];
        for(int i=0;i<coins.length;i++){
            Arrays.fill(dp[i], -1);
        }
        return getCount(amount,coins.length - 1, coins, dp);
    }

    public static int getCount(int amt, int i, int[] coins, int[][] dp){
        if(amt == 0){
            return 1;
        }
        if(amt < 0){
            return 0;
        }
        if(i<0){
            return 0;
        }

        if(dp[i][amt] != -1){
            return dp[i][amt];
        }
       return dp[i][amt] = getCount(amt - coins[i], i,coins, dp) + getCount(amt,i-1 ,coins,dp);
    }
}