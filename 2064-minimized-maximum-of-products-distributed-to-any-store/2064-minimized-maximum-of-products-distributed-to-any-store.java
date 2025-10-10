class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int m = quantities.length;
        int l = 1;
        int r = quantities[0];
        for(int i=0;i<m;i++){
            r = Math.max(r, quantities[i]);
        }
        int ans = 0;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(canDistribute(mid, quantities, n)){
                ans = mid;
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return ans;
    }

    public boolean canDistribute(int x, int[] quantities, int n){
        int cnt = 0;
        
        for(int i : quantities){
            
                cnt += (int)Math.ceil(i*1.0 / x);
                
            
            if (cnt > n) return false; 
        }
        return cnt <= n;
    }
}