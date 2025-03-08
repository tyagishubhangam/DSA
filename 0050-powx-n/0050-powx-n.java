class Solution {
    public double myPow(double x, int n) {
        
       double ans = getAns(x,Math.abs(n));
       if(n < 0){
        return 1/ans;
       }
       return ans;

        
    }

    public static double getAns(double x, int n){
         if(n == 0){
            return 1;
        }


        double res = (getAns(x,n/2));
            if(n % 2 == 0){
                
                    return (res * res);
            }
            return( res * res* x);
        
    }
}