class Solution {
    public int removeElement(int[] nums, int val) {
        int freq = 0;
        int r = nums.length - 1;
        int l = 0;
        while(l<=r)
        {
            if(nums[r] == val){
                r--;
                freq++;
            }else{
                if(nums[l] == val){
                    freq++;
                    int tmp = nums[r];
                    nums[r] = nums[l];
                    nums[l] = tmp;
                    r--;
                }
                l++;
            }
        }
        return nums.length - freq;
    }
}