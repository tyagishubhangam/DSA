class Solution {
    public int firstMissingPositive(int[] nums) {
        boolean flag = false;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 1){
                flag = true;
                break;
            }
        }
        if(flag == false){
            return 1;
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i] > nums.length || nums[i] <= 0){
                nums[i] = 1;
            }
        }
        for(int i=0;i<nums.length;i++){
            nums[(nums[i] - 1)%nums.length] += nums.length;
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i] <= nums.length){
                return i+1;
            }
        }
        return nums.length + 1;
    }
}