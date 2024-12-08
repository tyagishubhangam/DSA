class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int i = 0, j = 1;
        if(nums.length == 1){
            return false;
        }
        while(i < nums.length){
            if(Math.abs(i-j) <= k && j < nums.length){
                if(nums[i] == nums[j]){
                    return true;
                }j++;
            }else{
                i++;
                j = i + 1;
                
            }
        }
        return false;
    }
}