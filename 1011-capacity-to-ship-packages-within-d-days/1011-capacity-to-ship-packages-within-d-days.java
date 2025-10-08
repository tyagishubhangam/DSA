class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        long totalWt = 0;
        long maxWt = 0;
        for(int i : weights){
            totalWt += i;
            maxWt = Math.max(maxWt, i);
        }
        long l = maxWt;
        long r = totalWt;
        long ans = Long.MAX_VALUE;
        while(l<=r){
            long mid = l + (r - l)/2;
            if(isPossible(days, weights, mid)){
                r = mid - 1;
                ans = Math.min(ans, mid);
            }else{
                l = mid + 1;
            }
        }
        return (int)ans;
    }

    public boolean isPossible(int days, int[] weighs, long x){
        long tmp = 0;
        int l = 0;
        int d = 0;
        while(l < weighs.length){
            while(l< weighs.length && tmp+weighs[l] <= x){
                tmp += weighs[l];
                l++;
            }
            tmp = 0;
            d++;
        }
        return d <= days;
    }
}