class Solution {
    public long maxAlternatingSum(int[] nums) {
        boolean shouldAdd = true;
        long[][] dp = new long[nums.length][2];
        for(int i=0;i<nums.length;i++){
            Arrays.fill(dp[i], Long.MIN_VALUE);
        }
        
        return recurse(0, nums, shouldAdd, dp);
    }

    public long recurse(int i, int[] nums, boolean shouldAdd, long[][] dp){
        if(i >= nums.length){
            return 0;
        }
        int numToAdd = (shouldAdd ? nums[i] : (nums[i]*-1));
        int flag = numToAdd > 0 ? 0 : 1;
        if(dp[i][flag] != Long.MIN_VALUE){
            return dp[i][flag];
        }
        long take = numToAdd + recurse(i+1, nums, !shouldAdd, dp);
        long skip = recurse(i+1, nums, shouldAdd, dp);

        return dp[i][flag] = Math.max(take, skip);
    }
}