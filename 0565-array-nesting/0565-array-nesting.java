class Solution {
    public int arrayNesting(int[] nums) {
        int ans = 0;
        for(int i=0;i<nums.length;i++){
            int count = 0;
            if(nums[i]>=0){
                int idx = i;
                int val = nums[i];

                while(nums[idx] >= 0){
                    int tmp = nums[idx];
                    nums[idx] = -1;
                    count += 1;
                    idx = tmp;
                }
                ans = Math.max(count, ans);
            }
        }
        return ans;
    }
}