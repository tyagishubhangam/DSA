class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        if(n == 1){
            return nums[0];
        }
        Arrays.fill(dp, -1);
        int path1 = recurse(0, nums, dp);
        if(n <= 1){
            return path1;
        }
        Arrays.fill(dp, -1);
        int path2 = recurse2(1, nums, dp);

        return Math.max(path1, path2);
    }

    public int recurse(int i, int[] nums, int[] dp){
        if(i >= nums.length-1){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }

        int take = nums[i] + recurse(i+2, nums, dp);
        int notTake = recurse(i+1, nums, dp);
        return dp[i] = Math.max(take, notTake);
    }
    
    public int recurse2(int i, int[] nums, int[] dp){
        if(i >= nums.length){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }

        int take = nums[i] + recurse2(i+2, nums, dp);
        int notTake = recurse2(i+1, nums, dp);
        return dp[i] = Math.max(take, notTake);
    }    
}