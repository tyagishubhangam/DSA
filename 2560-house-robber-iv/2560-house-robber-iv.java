class Solution {
    public int minCapability(int[] nums, int k) {
        int l = (int)1e6;
        int r = -1;
        for(int i : nums){
            l = Math.min(i, l);
            r = Math.max(r, i);
        }
        int ans = 0;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(isValid(mid, nums, k)){
                ans = mid;
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }

        return ans;
    }
    public boolean isValid(int x, int[] arr, int k){
        int cnt = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] <= x){
                cnt++;
                i++;
            }
        }
        return cnt >= k;
    }
}