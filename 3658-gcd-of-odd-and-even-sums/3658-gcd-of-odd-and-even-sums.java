class Solution {
    public int gcdOfOddEvenSums(int n) {
        if(n == 1){
            return 1;
        }
        int oddSum = n * n;
        int evenSum = (2*n*(2*n+1)/2) - oddSum;
        int divisor = oddSum;
        int dividend = evenSum;
        while(dividend % divisor != 0){
            int tmp = dividend % divisor;
            dividend = divisor;
            divisor = tmp;
        }
        return dividend / divisor;
    }
}