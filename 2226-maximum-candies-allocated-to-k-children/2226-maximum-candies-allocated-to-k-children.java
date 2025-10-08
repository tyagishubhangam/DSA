class Solution {
    public int maximumCandies(int[] candies, long k) {
        
        int n = candies.length;
        long total = 0;
        long l = 1;
        for(int i : candies){
            total += i;
            
        }
        long r = total / k;
        long ans = 0;
        while(l <= r){
            long mid = l + (r - l ) / 2;
            if(isValid(mid, candies, k)){
                ans = Math.max(ans, mid);
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return (int)ans;
    }

    public boolean isValid(long x, int[] candies, long k){
        
        long childs = 0;
        for(int i : candies){
            
            childs += i / x;
        }

        return childs >= k;
       
    }
}