class Solution {
    public int singleNonDuplicate(int[] nums) {
        int x = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            x ^= nums[i];
        }

        return x;
    }
}