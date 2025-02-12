class Solution {
    public boolean increasingTriplet(int[] nums) {
        int l = nums.length;
        int[] preMin = new int[l];
        int[] suffMax = new int[l];
        suffMax[l - 1] = nums[l - 1];
        preMin[0] = nums[0];
        for(int i=1;i<l;i++){
            preMin[i] = Math.min(preMin[i - 1], nums[i]);
        }
        for(int i=l-2;i>=0;i--){
            suffMax[i] = Math.max(suffMax[i+1], nums[i]);
            
        }
        for(int i=1;i<l - 1;i++){
            if(preMin[i-1] <nums [i] && nums[i] < suffMax[i+1]){
                return true;
            }
        }
        return false;
    }
}