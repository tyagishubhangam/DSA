class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if(n == 1){
            return nums[0] == target?0:-1;
        }
        int l = 0;
        int r = n - 1;
        int pivot = getPivot(nums);
        if(target < nums[pivot]){
            return -1;
        }
        if(target == nums[pivot]){
            return pivot;
        }
        if(target > nums[pivot]){
            if(target <= nums[n - 1]){
                l = pivot;
                r = n - 1;
            }else{
                l = 0;
                r = pivot-1;
            }
        }
        while(l <= r){
            int mid = l + (r - l) / 2;

            // I got the target
            if(nums[mid] == target){
                return mid;
            }

            if(nums[mid] > target){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }

        return -1;
    }
    public int getPivot(int[] nums){
        int n = nums.length;
        if(nums[0] < nums[n-1]){
            return 0;
        }
        int l = 0;
        int r = n - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(mid == 0){
                if(nums[mid] > nums[mid + 1]){
                    return mid + 1;
                }else{
                    l = mid + 1;
                }
                
            }else{
                if(mid == n - 1){
                    if(nums[mid] < nums[mid - 1]){
                        return mid;
                    }else{
                        r = mid - 1;
                    }
                }else{
                    if(nums[mid] > nums[mid+1]){
                        return mid+1;
                    }
                    if(nums[mid] < nums[mid - 1]){
                        return mid;
                    }
                    if(nums[mid] > nums[n - 1]){
                        l = mid + 1;
                    }else{
                        r = mid - 1;
                    }
                }
            }
        }
        return -1;
    }
}