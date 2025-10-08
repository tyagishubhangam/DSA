class Solution {
    public boolean isPerfectSquare(int num) {
        int l = 1;
        int r = num+1/2;
        while(l <= r){
            int mid = l + (r-l)/2;
            if((mid) == Math.sqrt(num)){
                return true;
            }
            if((mid) > Math.sqrt(num)){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return false;
    }
}