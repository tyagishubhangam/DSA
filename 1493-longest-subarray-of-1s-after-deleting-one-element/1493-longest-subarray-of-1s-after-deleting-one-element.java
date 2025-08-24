class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int res = 0;
        int l = 0;
        int r = 0;
        // int currSum = 0;
        int countZeros = 0;
        while(r < n){
            if(nums[r] == 0){
                countZeros++;
            }
            while(l < r && countZeros > 1){
                if(nums[l] == 0){
                    countZeros--;
                }
                l++;
            }
            res = Math.max(res, r-l);
            r++;
            
        }

        return res;
    }
}