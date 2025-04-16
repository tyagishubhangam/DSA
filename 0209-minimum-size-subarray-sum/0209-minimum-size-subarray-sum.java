class Solution {
    public int minSubArrayLen(int k, int[] nums) {
        int n = nums.length;
        int[] preSum = new int[n];
        preSum[0] = nums[0];
        for(int i=1;i<n;i++){
            preSum[i] = preSum[i-1] + nums[i];
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int l = i;
            int r = n - 1;
            int j = -1;
            while(l<=r){
                int mid = (l + r) / 2;
                int subSum = 0;
                if(i == 0){
                    subSum = preSum[mid];
                }else{
                    subSum = preSum[mid] - preSum[i-1];
                }
                if(subSum >= k){
                    j = mid;
                    r = mid -1;
                }else{
                    l = mid + 1;
                }
            }
            ans = j != -1?Math.min(ans, j - i + 1):ans;
        }
        return ans!= Integer.MAX_VALUE ? ans: 0;
    }
}