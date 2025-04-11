class Solution {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for(int i=0;i<s.length();i++){
            Arrays.fill(dp[i], -1);
        }
        return getAns(s, new StringBuilder(s).reverse().toString(),0,0,dp);
    }

    public static int getAns(String s, String revS, int i, int j, int[][] dp){
        if(i == s.length() || j == revS.length()){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(s.charAt(i) == revS.charAt(j)){
            return 1+getAns(s, revS, i+1, j+1,dp);
        }
        return dp[i][j] = Math.max(getAns(s, revS, i, j+1,dp),getAns(s, revS, i+1, j,dp));
    }
}