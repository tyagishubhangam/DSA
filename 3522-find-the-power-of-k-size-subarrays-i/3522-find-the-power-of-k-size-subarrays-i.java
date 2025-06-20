class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[ n - k + 1];
        int count = 1;
        for(int i=1;i<k;i++){
            if(nums[i] == nums[i - 1]+1){
                count++;
            }else{
                count = 1;
            }
        }

        if(count >= k){
            res[0] = nums[k-1];
        }else{
            res[0] = -1;
        }

        int l = 1;
        int r = k;
        while(r < n){
            if(nums[r] == nums[r - 1]+1){
                count++;
            }else{
                count = 1;
            }

            if(count >= k){
                res[l] = nums[r];
            }else{
                res[l] = -1;
            }
            r++;
            l++;
        }
        return res; 
    }
}