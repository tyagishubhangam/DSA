class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        int ops = 0;
        

        
        for(int i=0;i<n;i++){
            int rem = nums[i] % 3;
            if(rem != 0){
                ops += 1;
            }
        }
        return ops;
    }

    
}