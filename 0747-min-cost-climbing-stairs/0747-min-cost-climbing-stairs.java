class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        for(int i=0;i<cost.length;i++){
            Arrays.fill(dp,-1);
        }
        return Math.min(helper(0,dp,cost),helper(1,dp,cost));
    }

    public static int helper(int i, int[] dp,int[] cost){
        if(i >= cost.length){
            return 0;
        }
        
        if(dp[i] != -1){
            return dp[i];
        }
        int p1 = helper(i+1,dp,cost);
        int p2 = helper(i+2,dp,cost);
        return dp[i] = cost[i]+Math.min(p1,p2);

    }
}