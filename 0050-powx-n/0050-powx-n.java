class Solution {
    public double myPow(double x, int n) {
       double ans = getAns(x,n);
      return n<0?(1/ans):ans;

    }

    public static double getAns(double x, int n){
         if(n == 0){
            return 1;
        }
        double tmp = getAns(x, n/2);
        if(n % 2 != 0){
            return x * tmp*tmp;
        }
        return tmp * tmp;
    }
}