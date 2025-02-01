class Solution {
    public void rotate(int[] nums, int k) {
        k= k % nums.length;
       
        reverseArr(nums, nums.length - k , nums.length - 1);
        reverseArr(nums,0, nums.length - k - 1);
        reverseArr(nums,0, nums.length - 1);
        
    }

    public static void reverseArr(int[] nums, int l, int r){
        
        while(l<r){
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            
            l++;
            r--;
        }
        
    }
}