class Solution {
    public boolean isMonotonic(int[] nums) {
        if(nums.length == 1 || nums.length == 2){
            return true;
        }
        if(checkDecreasing(nums) == false && checkIncreasing(nums) == false){
            return false;
        }
        return true;
        
    }
    public boolean checkDecreasing(int[] nums){
        for(int i=0;i<nums.length - 1;i++){
            if(nums[i]< nums[i + 1]){
                return false;
            }
        }
        return true;
    }
    public boolean checkIncreasing(int[] nums){
        for(int i=0;i<nums.length - 1;i++){
            if(nums[i]> nums[i + 1]){
                return false;
            }
        }
        return true;
    }
}