class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int l = 0;
        int r = 0;
        
        for(int i=0;i<n;i++){
            r += nums[i];
            l = Math.max(l,nums[i]);
        }
        int ans = l;
        while(l<=r){
            int mid = (l + r) / 2;
            boolean isValid = check(mid,k,nums);
            if(!isValid){
                l = mid + 1;
            }else{
                boolean prev = check(mid - 1, k, nums);
                if(!prev){
                    ans = mid;
                    break;
                }else{
                    r = mid - 1;
                }
            }
        }
        return ans;
    }
    public static boolean check(int mid, int m ,int[] nums){
        int cnt = 1;
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            if(sum + nums[i] > mid){
                cnt++;
                sum = nums[i];
            }else{
                sum += nums[i];
            }
        }
        return cnt <= m;
    }
}