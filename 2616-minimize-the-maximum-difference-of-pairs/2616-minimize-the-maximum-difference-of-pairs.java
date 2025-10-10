class Solution {
    public int minimizeMax(int[] nums, int p) {
        int n = nums.length;
        int l = 0;
         
        Arrays.sort(nums);
        int r = nums[n-1] - nums[0];
        int ans = r;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(canWe(mid, nums, p)){
                ans = mid;
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return ans;
    }
    public boolean canWe(int x, int[] nums, int p){
        int i = 0;
        int cnt = 0;
        while(i<=nums.length-2){
            if(Math.abs(nums[i+1]-nums[i]) <= x){
                cnt++;
                i+=2;
            }else{
                i++;
            }
        }
        return cnt >= p;
    }
}