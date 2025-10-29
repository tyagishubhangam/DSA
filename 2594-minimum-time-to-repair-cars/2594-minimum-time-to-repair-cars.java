class Solution {
    public long repairCars(int[] ranks, int cars) {
        int n = ranks.length;
        long l = ranks[0];
        long r = ranks[0];
        for(int i=0;i<n;i++){
            l = Math.min(ranks[i], l);
            r = Math.max(ranks[i], r);
        }
        long ans = Long.MAX_VALUE;
        r = (long)Math.pow(cars,2) * r;
        while(l <= r){
            long mid = l + (r - l) / 2;
            if(isValid(ranks, mid, cars)){
                ans = Math.min(ans, mid);
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return ans;
    }

    public boolean isValid(int[] ranks, long mid, int cars){
        int n = ranks.length;
        int cnt = 0;
        for(int i=0;i<n;i++){
            cnt += Math.floor(Math.sqrt(mid / ranks[i]));
        }

        return cnt >= cars;
    }
}