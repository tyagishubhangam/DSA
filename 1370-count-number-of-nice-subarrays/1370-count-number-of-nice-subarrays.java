class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> mpp = new HashMap<>();
        mpp.put(0,1);
        int count = 0;
        int preSum = 0;
        for(int i=0;i<nums.length;i++){
            preSum += nums[i] % 2;
            count += mpp.getOrDefault(preSum - k, 0);
            mpp.put(preSum, mpp.getOrDefault(preSum, 0) + 1);
        }
        return count;
        
    }
}