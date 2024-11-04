class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int mid = (low + high)/2;
        while(low <= high ){
            mid = (low + high)/2;
            if(nums[mid] > target){
                high = mid-1;
            }else if(nums[mid] < target){
                low = mid + 1;
            }else if(nums[mid] == target){
                return mid;
            }
        }
        return -1;
    }
}