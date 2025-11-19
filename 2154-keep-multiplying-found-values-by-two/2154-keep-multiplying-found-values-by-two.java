class Solution {
    public int findFinalValue(int[] nums, int original) {
        int n = nums.length;
        while(find(original, nums)){
            original *= 2;
        }

        return original;

    }

    public static boolean find(int x, int[] nums){
        for(int i=0;i<nums.length;i++){
            if(nums[i] == x){
                return true;
            }
        }

        return false;
    }
}