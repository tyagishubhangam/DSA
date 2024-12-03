class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int count = 0;
        int preSum = 0;
        Map<Integer, Integer> mpp = new HashMap<>();
        mpp.put(0, 1);
        for(int i=0;i<nums.length;i++){
            preSum += nums[i];
            int diff = preSum - goal;
            count += mpp.getOrDefault(diff, 0);
            mpp.put(preSum, mpp.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }
}