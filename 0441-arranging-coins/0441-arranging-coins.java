class Solution {
    public int arrangeCoins(int n) {
        int cnt = 0;
        int st = 1;
        while(n >= st){
            cnt++;
            n-= st;
            st++;
        }
        return cnt;
    }
}