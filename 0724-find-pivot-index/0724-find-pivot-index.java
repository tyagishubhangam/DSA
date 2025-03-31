class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return 0;
        }
        int[] preSum = new int[n];
        int[] suffSum = new int[n];
        preSum[0] = nums[0];
        for(int i=1;i<n;i++){
            preSum[i] = preSum[i-1] + nums[i];
        }
        suffSum[n-1] = nums[n - 1];
        for(int j=n-2;j>=0;j--){
            suffSum[j] = suffSum[j+1] + nums[j];
        }
        
        int pivot = -1;
        for(int i=0;i<n;i++){
            if(i == 0){
                if(suffSum[1] == 0){
                    pivot = 0;
                    break;
                }
            }else{
                if(i == n-1){
                    if(preSum[n - 2] == 0){
                        pivot = n - 1;
                        break;
                    }
                }else{
                    if(preSum[i-1] == suffSum[i+1]){
                        pivot = i;
                        break;
                    }
                }
            }
        }
        return pivot;
    }
}