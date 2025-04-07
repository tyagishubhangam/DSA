class Solution {
    public int climbStairs(int n) {
        return recurse(0, n);
    }

    public static int recurse(int steps, int n){
        if(steps == n){
            return 1;
        }
        if(steps > n ){
            return 0;
        }
        return recurse(steps+1,n) + recurse(steps + 2, n);
    }
}