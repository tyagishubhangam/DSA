class Solution {
    public int maximumGap(int[] nums) {
        if(nums.length <= 1){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i : nums){
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        if(max - min == 0){
            return 0;
        }

        int gap = (max - min)/(nums.length - 1);
        if((max - min)%(nums.length - 1) != 0){
            gap++;
        }
        int[] minArr = new int[nums.length];
        int[] maxArr = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            minArr[i] = Integer.MAX_VALUE;
            maxArr[i] = Integer.MIN_VALUE;
        }
        for(int i=0;i<nums.length;i++){
            int bkt = (nums[i] - min)/(gap);
            // System.out.println(bkt);
            minArr[bkt] = Math.min(minArr[bkt], nums[i]);
            maxArr[bkt] = Math.max(maxArr[bkt], nums[i]);
        }
        int ans = Integer.MIN_VALUE;
        int prev = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(minArr[i] == Integer.MAX_VALUE){
                continue;
            }
            if(prev == Integer.MIN_VALUE){
                prev = maxArr[i];
            }
            if(prev >= Integer.MIN_VALUE){
                ans = Math.max(ans, minArr[i] - prev);
                prev = maxArr[i];
            }
        }
        return ans;
    }
}