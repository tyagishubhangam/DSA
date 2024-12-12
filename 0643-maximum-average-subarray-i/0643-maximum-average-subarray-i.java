class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double maxAvg = Integer.MIN_VALUE;
        int l = 0, r = 0;
        double sum = 0;
        // if(nums.length == 0){
        //     return 0;
        // }
        while(r < nums.length){
            sum += nums[r];
            if((r - l + 1) == k){
                maxAvg = Math.max(maxAvg,(sum / k));
                sum -= nums[l];
                l++;
            }   
            r++;
        }
            return maxAvg;
    }
}