class Solution {
    static int minDeletions(String s) {
        // code here
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i], -1);
        }
        
        return n - LCS(n-1,n-1,s, new StringBuilder(s).reverse().toString(),dp);
        
    }
    
    public static int LCS(int i, int j, String s, String revS, int [][] dp){
        if(i == -1 || j == -1){
            return 0;
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        if(s.charAt(i) == revS.charAt(j)){
            return dp[i][j] = 1 + LCS(i-1, j-1, s, revS, dp);
        }
        return dp[i][j] = Math.max(LCS(i-1, j, s, revS, dp), LCS(i, j-1, s, revS, dp));
    }
}