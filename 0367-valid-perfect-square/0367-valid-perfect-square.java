class Solution {
    public boolean isPerfectSquare(int num) {
        long l = 1;
        long r = num;
        long mid = (l + r) / 2;
        
        while(l<=r){
            mid = (l + r) / 2;
            if((mid*mid) == num){
                return true;
            }else{
                if((mid*mid) > num){
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }
        }
        return false;
    }
}