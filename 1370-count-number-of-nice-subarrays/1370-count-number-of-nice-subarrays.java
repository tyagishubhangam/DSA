class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int countEvens = 0;
        int l = 0;
        int r = 0;
        int countOdds = 0;
        int ans = 0;
        while(r < n){
            if(nums[r] % 2 != 0){
                countOdds += 1;
            }

            while(l<r && ((nums[l] % 2 == 0) || countOdds > k)){
                if(nums[l] % 2 == 0){
                    countEvens++;
                }else{
                    countEvens = 0;
                }

                if(nums[l] % 2 != 0){
                    countOdds -= 1;
                }
                l++;
            }
            if(countOdds == k){
                ans += 1 + countEvens;
            }
            r++;
        }

        return ans;
    }
}


// isko same approach se kara hai as leetcode 930. Binary Subarrays With Sum