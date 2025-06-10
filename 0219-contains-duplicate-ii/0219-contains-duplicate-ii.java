class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> hs = new HashMap<>();
        for(int i=0;i<n;i++){
            if(hs.get(nums[i]) == null){
                hs.put(nums[i], i);
            }else{
                int diff = i - hs.get(nums[i]);
                if(diff <= k){
                    return true;
                }else{
                    hs.put(nums[i], i);
                }
            }
        }

        return false;
    }
}