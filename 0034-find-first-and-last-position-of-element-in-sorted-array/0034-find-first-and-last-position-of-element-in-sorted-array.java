class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int leftIdx = getLeftIdx(nums, target);
        int rightIdx = getRightIdx(nums, target);
        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        if(leftIdx == -1){
            return ans;
        }
        ans[0] = leftIdx;
        ans[1] = rightIdx;
        return ans;
    }

    public int getLeftIdx(int[] nums, int target){
        int n = nums.length;
        int l = 0;
        int r = n-1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(target <= nums[mid]){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        if(l < n && nums[l] == target){
            return l;
        }

        return -1;
    }

    public int getRightIdx(int[] nums, int target){
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        while(l<=r){
            int mid = l + (r - l) / 2;
            if(target >= nums[mid]){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }

        if(r >= 0 && nums[r] == target){
            return r;
        }

        return -1;
    }
}