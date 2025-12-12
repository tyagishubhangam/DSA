class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int total = 0;
        int l = 1;
        int r = piles[0];
        for(int i : piles){
            total += i;
            
            r = Math.max(i, r);
        }
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(calTime(mid, piles) <= h){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }

        return l;
    }

    public double calTime(int k, int[] piles){
        double duration = 0;
        for(int p : piles){
            if(p%k != 0){
                duration += p / k;
                duration++;
            }else{
                duration += p / k;
            }
        }
        // System.out.println("K"+k+"--"+duration);
        return duration;
    }
}