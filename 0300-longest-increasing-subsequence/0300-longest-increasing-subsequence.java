class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] LIS = new int[nums.length];
        LIS[0] = 1;
        int ans = 1;
        for(int i=1;i<nums.length;i++){
            LIS[i] = 1;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    LIS[i] = Math.max(LIS[i],1+LIS[j]);
                }
            }
            ans = Math.max(ans, LIS[i]);
        }

        return ans;
    }
}