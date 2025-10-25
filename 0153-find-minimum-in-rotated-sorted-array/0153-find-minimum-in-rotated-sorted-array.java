class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        int l = 0;
        int r = n - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(mid == 0){
                if(nums[mid] > nums[mid+1]){
                    return nums[mid+1];
                }
                if(nums[mid] < nums[mid+1] && nums[mid] < nums[n-1]){
                    return nums[mid];
                }else{
                    l = mid + 1;
                }

            }else{
                if(mid == n-1){
                    if(nums[mid] < nums[mid - 1] && nums[mid] < nums[0]){
                        return nums[mid];
                    }else{
                        r = mid - 1;
                    }
                }else{
                    if(nums[mid] > nums[mid + 1]){
                        return nums[mid+1];
                    }
                    if(nums[mid] < nums[mid-1]){
                        return nums[mid];
                    }
                    if(nums[mid] < nums[mid+1] && nums[mid] > nums[n-1]){
                        l = mid + 1;
                    }else{
                        r = mid - 1;
                    }
                }
            }
        }
        return 0;
    }
}