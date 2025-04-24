class Solution {
    public int rob(int[] nums) {
        
        int prevPrev = nums[0];
        if(nums.length == 1){
            return prevPrev;
        }
        if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        int prev = Math.max(prevPrev,nums[1]);
        int robFromFirst = 0;
        for(int i=2;i<nums.length-1;i++){
            int curr = Math.max(prevPrev + nums[i], prev);
            prevPrev = prev;
            prev = curr;
        }
        robFromFirst = prev;

        prevPrev = nums[1];
        prev = Math.max(prevPrev,nums[2]);
        int robFromSecond = 0;
        for(int i=3;i<nums.length;i++){
            int curr = Math.max(prevPrev + nums[i], prev);
            prevPrev = prev;
            prev = curr;
        }
        robFromSecond = prev;

        return Math.max(robFromFirst, robFromSecond);
    }
}