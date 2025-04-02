class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        // if(n == 1){
        //     return nums[0];
        // }
        if(nums[0] <= nums[n - 1]){
            return nums[0];
        }
        int l = 0;
        int r = n - 1;
        int mid = (l + r) / 2;
        int pivot = 0;
        while(l<=r){
            mid = (l + r) / 2;
            if(nums[mid] > nums[mid + 1] ){
                pivot = mid;
                break;
            }else{
                if(nums[mid] > nums[n - 1]){
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }
        }
        
           return nums[pivot+1]; 
        

    }
}