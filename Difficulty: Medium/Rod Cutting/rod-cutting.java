class Solution {
    public int cutRod(int[] price) {
        // code here
        int n = price.length;
        int[][] dp = new int[n+1][n+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i], -1);
        }
        
        return recurse(n-1,price,n,dp);
        
    }
    
    public static int recurse(int i, int[] price, int len, int[][] dp){
        if(i<0){
            return 0;
        }
        if(len < 0){
            return 0;
        }
        if(len == 0){
            return 0;
        }
        if(dp[i][len] != -1){
            return dp[i][len];
        }
        int take = 0;
        if((len-i-1) >=0){
            take = price[i] + recurse(i,price,len - i-1,dp);
        }
        
        int notTake = recurse(i-1,price,len,dp);
        return dp[i][len]=Math.max(take,notTake);
        
    }
}