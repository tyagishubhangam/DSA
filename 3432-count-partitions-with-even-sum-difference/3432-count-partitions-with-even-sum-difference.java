class Solution {
    public int countPartitions(int[] nums) {
        int n = nums.length;
        int[] preSum = new int[n];
        preSum[0] = nums[0];
        for(int i=1;i<n;i++){
            preSum[i] = preSum[i-1] + nums[i];
        }
        int cnt = 0;
        for(int i=0;i<n-1;i++){
            int left = preSum[i];
            int right = preSum[n-1]-preSum[i];
            if((left - right) % 2 == 0){
                cnt++;
            }
        }
        return cnt;
    }
}