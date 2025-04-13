class Solution {
    int MOD = 1000000007;
    public int countGoodNumbers(long n) {
        long oddPlaces = n/2;
        long evenPlaces = n - oddPlaces;
        long ans = (raiseToPow(4,oddPlaces) % MOD) * (raiseToPow(5,evenPlaces)%MOD)%MOD;
        return (int)ans;
    }

    public long raiseToPow(int i, long j){
        if(j == 0){
            return 1;
        }
        long xt = raiseToPow(i, j/2) % MOD;
        if(j%2 != 0){
            return (((((xt%MOD) *(xt%MOD))%MOD) * (i%MOD))%MOD);
        }
        return (((xt%MOD) *(xt%MOD))%MOD);
    }
}