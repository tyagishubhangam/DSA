class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        int cnt = 1;
        int prevCnt = 0;
        if(k == 1){
            return true;
        }
        for(int i=1;i<n;i++){
            
            if(nums.get(i) > nums.get(i-1)){
                cnt++;
                if(cnt >= 2*k){
                    return true;
                }
            }else{
                
                prevCnt = cnt;
                cnt = 1;
            }
            if(cnt >= 2*k){
                return true;
            }

            if(prevCnt >= k && cnt >= k){
                    return true;
                }
        }
        
        return false;
    }
}