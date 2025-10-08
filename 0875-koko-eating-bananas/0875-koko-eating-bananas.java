class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int total = 0;
        int n = piles.length;
        int r = 0;
        for(int i=0;i<n;i++){
            total += piles[i];
            r = Math.max(r,piles[i]);
        }
        int l = (int)Math.ceil(total*1.0 / h);
        int ans = Integer.MAX_VALUE;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(isValid(h,piles, mid)){
                r = mid - 1;
                ans = Math.min(ans, mid);
            }else{
                l = mid + 1;
            }
        }
        return ans;    
    }

    public boolean isValid(int k, int[] piles, int consumed){
        int hrs = 0;
        for(int i : piles){
            hrs += (int)Math.ceil(i*1.0 / consumed);
        }
        return hrs <= k;
    }
}