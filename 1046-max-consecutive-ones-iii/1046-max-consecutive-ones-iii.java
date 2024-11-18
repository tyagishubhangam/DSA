class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0, r = 0, maxLen = 0, count = 0;
        while(r < nums.length){
            if(nums[r] == 0){
                count++;
            }
            if(count > k){
                if(nums[l] == 0){
                    count--;
                }
                l++;
            }
            if(count <= k){
                maxLen = Math.max(r - l + 1, maxLen);
            }
            r++;
        }
        return maxLen;
    }
}