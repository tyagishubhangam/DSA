class Solution {
    public int mySqrt(int x) {
        long l = 0;
        long r = x;
        long mid = (l + r) / 2;
        while(l<=r){
             mid = (l + r) / 2;
            if(mid*mid  == x){
                return (int)mid;
            }else{
                if(mid*mid > x)
                    r = mid - 1;
                else
                    l = mid + 1;
            }
        }
        return (int)r;
    }
}