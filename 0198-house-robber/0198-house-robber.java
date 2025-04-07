class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for(int i=0;i<n;i++){
            dp[i] = -1;
        }
        return getAmount(0,dp,nums);
    }

    public static int getAmount(int idx,int[] dp, int[] arr){
        if(idx >= arr.length){
            return 0;
        }
        if(dp[idx] != -1){
            return dp[idx];
        }
        int incl = arr[idx] + getAmount(idx+2,dp,arr);
        int excl = getAmount(idx + 1, dp, arr);
        dp[idx] = Math.max(incl, excl);
        return dp[idx];
        
    }
}