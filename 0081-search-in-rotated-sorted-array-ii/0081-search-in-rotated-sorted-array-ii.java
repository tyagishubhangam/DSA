class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n-1;
        if(n == 1){
            return nums[0] == target;
        }
        int pivot = getPivot(nums);
        System.out.println(pivot);
        if(nums[pivot] == target){
            return true;
        }
        if(target > nums[pivot]){
            if(target > nums[n-1]){
                l = 0;
                r = pivot-1;
            }else{
                l = pivot;
                r = n-1;
            }
        }else{
            return false;
        }
        while(l <= r){
            int mid = l + (r - l) / 2;
        if(nums[mid] == target){
                return true;
            }
            if(nums[mid] > target){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return false;
    }

    public int getPivot(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        if (nums[l] < nums[r]) {
            return 0;
        }

        while (l < r) {
            while (l < r && nums[l] == nums[l + 1]) {
                l++;
            }
            while (l < r && nums[r] == nums[r - 1]) {
                r--;
            }
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return r;
    }
}