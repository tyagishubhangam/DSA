class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return Math.max(recurse(0, nums, dp), recurse(1,nums, dp)); 

    }

    public int recurse(int i, int[] nums, int[] dp){
        if(i >= nums.length){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        int take = nums[i]+ recurse(i+2, nums, dp);
        int notTake = recurse(i+1, nums, dp);

        return dp[i] = Math.max(take, notTake);

    }
}