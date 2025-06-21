class Solution {
    public int maxFrequency(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int l = 0;
        int r = 0;
        int maxFreq = 0;
        long currSum = 0;
        while(r < n){
            currSum += nums[r];
            int len = r - l + 1;
            long tmpSum = (long)len * (long)nums[r];
             
            while(l<r && (long)(tmpSum - currSum) > k ){
                currSum -= (long)nums[l];
                l++;
                tmpSum = (long)(r-l+1) * (long)nums[r];
            }

            if((long)(tmpSum - currSum) <= k){
                maxFreq = Math.max(maxFreq, r-l+1);
            }

            r++;
        }

        return maxFreq;
    }
}