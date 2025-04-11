class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        for(int i=0;i<word1.length();i++){
            Arrays.fill(dp[i], -1);
        }
        int common = getAns(word1, word2, 0,0,dp);
        int totalLength = word1.length() + word2.length();
        return (totalLength - (2 * common));
    }

    public static int getAns(String word1, String word2, int i, int j, int[][] dp){
        if(i == word1.length() || j == word2.length()){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(word1.charAt(i) == word2.charAt(j)){
            return 1+ getAns(word1, word2, i+1, j+1,dp);
        }
        return dp[i][j] = Math.max(getAns(word1, word2, i+1, j,dp), getAns(word1, word2, i, j+1,dp));
    }
}