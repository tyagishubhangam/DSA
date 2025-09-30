class Solution {
    public int reverse(int x) {
        int n = x;
        long rev = 0;
        while(n != 0){
            int r = n % 10;
            rev = rev * 10 + r;
            n = n / 10;
        }

        if(rev > (int)2e31 -1 || rev < (int)(-2e31)){
            return 0;
        }

        return (int)rev;
    }
}