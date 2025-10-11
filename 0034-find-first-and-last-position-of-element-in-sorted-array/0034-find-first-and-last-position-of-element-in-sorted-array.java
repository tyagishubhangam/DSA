class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        return getAns(target, nums);
        
    }

    public int[] getAns(int target, int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = nums.length - 1;
        int[] ans = new int[] { -1, -1 };
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                if (mid == 0) {
                    ans[0] = mid;
                    break;
                }
                if (mid == n - 1) {
                    if (nums[mid] != nums[mid - 1]) {
                        ans[0] = mid;
                        break;
                    } else {
                        r = mid - 1;
                    }
                } else {
                    if (nums[mid] != nums[mid - 1]) {
                        ans[0] = mid;
                        break;
                    } else {
                        r = mid - 1;
                    }
                }
            } else {
                if (nums[mid] > target) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        l = 0;
        r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                if (mid == n - 1) {
                    ans[1] = n - 1;
                    break;
                }
                if (mid == 0) {
                    if (nums[mid] != nums[mid + 1]) {
                        ans[1] = mid;
                        break;
                    } else {
                        l = mid + 1;
                    }
                }else{
                    if(nums[mid] != nums[mid+1]){
                        ans[1] = mid;
                        break;
                    }else{
                        l = mid + 1;
                    }
                }

            }else{
                if (nums[mid] > target) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }

        return ans;
    }
}