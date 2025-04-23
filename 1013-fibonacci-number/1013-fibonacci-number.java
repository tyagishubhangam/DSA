class Solution {
    public int fib(int n) {
        if(n < 2){
            return n;
        }
        int prev = 1;
        int prevPrev = 0;
        
        for(int i=2;i<=n;i++){
            int curr = prev + prevPrev;
            prevPrev = prev;
            prev = curr;
        }

        return prev;
    }
}