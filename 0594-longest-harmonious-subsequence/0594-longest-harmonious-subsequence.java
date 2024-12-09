class Solution {
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int maxLen = 0;
        for(int i = 0;i<nums.length;i++){
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
            if(freq.containsKey(nums[i] + 1)){
                maxLen = Math.max(maxLen, (freq.get(nums[i]) + freq.get(nums[i] + 1)));
            }
            if(freq.containsKey(nums[i] - 1)){
                maxLen = Math.max(maxLen, (freq.get(nums[i]) + freq.get(nums[i] - 1)));
            }
        }
        return maxLen;
    }
}