class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = 0;
        // int maxL = 0;
        // int maxR = 0;
        int currSum = 0;
        int maxSum = nums[0];
        while(r < n){
            currSum += nums[r];
            if(currSum >= maxSum){
                maxSum = currSum;
                // maxL = l;
                // maxR = r;
            }

            if(currSum < 0){
                currSum = 0;
                l = r+1;
            }
            r++;

        }
        // System.out.println(maxL+"---"+maxR);
        return maxSum;
    }
}