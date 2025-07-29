class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int prod = 1;
        int zero = 0;
        for(int i=0;i<n;i++){
            if(nums[i] == 0){
                zero++;
                continue;
            }
            prod *= nums[i];
        }
        if((prod == 1 && zero == n) || zero > 1){
            prod = 0;
            return res;
        }
        for(int i=0;i<n;i++){
            if(nums[i] == 0){
                res[i] = prod;
                return res;
            }else{
                if(zero > 0){
                    res[i] = 0;
                }else{
                    res[i] = prod / nums[i];
                }
            }
        }

        return res;
    }
}