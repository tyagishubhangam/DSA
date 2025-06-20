class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int l = 0;
        int r = 0;
        long prod = 1;
        int ans = 0;
        while(r < n){
            prod *= nums[r];
            while(l<r && prod >= k){
                prod /= nums[l];
                l++;
            }
            if(prod < k){
                ans += (r - l + 1);  // yahan pe r-l + 1 determine karta hai ki no. of subarrays ending at r and within the window l to r. Kyunki agr poore subarray ka product condition satisfy kar raha hai toh usk ander jitne bhi subarrays hai voh bhi satisfy karnege . 
            }
            r++;
        }
        return ans;
    }
}