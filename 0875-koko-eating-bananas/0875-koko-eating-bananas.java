class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        long l = 1;
        long r = 0;
        for(int i=0;i<n;i++){
            r = Math.max(r, piles[i]);
        }
        while(l <= r){
            long mid = l + (r - l) / 2;
            long time = getTotalTimeToEat(piles, mid);
            if(time <= h){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return (int)l;
    }
    public long getTotalTimeToEat(int[] piles, long cnt){
        long tmp = 0;
        for(int pile : piles){
            tmp += (long)pile / cnt;
            if(pile % cnt != 0){
                tmp += 1;
            }

            }
            return tmp;
        }
    }
