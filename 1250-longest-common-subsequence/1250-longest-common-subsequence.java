class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }

        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }
            }
        }

        for(int i=1;i<=n;i++){
            
            for(int j=1;j<=m;j++){
                char cha = text1.charAt(i-1);
                char chb = text2.charAt(j-1);
                if(cha == chb){
                dp[i][j] = 1+dp[i-1][j-1];
            }else{
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
            }
            
            
        }
        return dp[n][m];
    }

}   