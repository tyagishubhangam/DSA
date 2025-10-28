class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        int n = time.length;
        long l = 1;
        long r =  (long)1e14;
        
        while(l <= r){
            long mid = l + (r - l) / 2;
            long cnt = getTotalTrips(time,mid);
            
            if(cnt >= totalTrips){
                r = mid-1 ;
            }else{
                l = mid + 1;
            }
        }

        return l;
    }

    public long getTotalTrips(int[] time, long t){
        long cnt = 0;
        for(int i : time){
            cnt += (t/i);
        }

        return cnt;
    }
}