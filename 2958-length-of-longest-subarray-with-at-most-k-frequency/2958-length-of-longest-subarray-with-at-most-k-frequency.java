class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> hs = new HashMap<>();
        int l = 0;
        int r = 0;
        int res = 0;
        while(r < n){
            hs.put(nums[r],hs.getOrDefault(nums[r],0) + 1);
            while(l<r && hs.get(nums[r]) > k){
                hs.put(nums[l],hs.get(nums[l]) - 1);
                
                l++;
            }
            res = Math.max(res, r - l + 1);
            r++;
        }

        return res;
    }
}