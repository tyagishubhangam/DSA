class Solution {
    public int fib(int n) {
        int[] fib = new int[n+1];
        if(n>0){
            fib[1] = 1;
        }
        fib[0] = 0;
        
        for(int i=2;i<=n;i++){
            fib[i] = fib[i-1] + fib[i-2];
        }

        // for(int i=0;i<=n;i++){
        //     System.out.print(fib[i]+" ");
        // }
        return fib[n];
    }
}