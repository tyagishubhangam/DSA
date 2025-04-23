class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length;
        int m = dungeon[0].length;
        int[][] dp = new int[n][m];
        dp[n-1][m-1] = dungeon[n-1][m-1] >0?1:1-dungeon[n-1][m-1];

        for(int i = n-1;i >= 0;i--){
            for(int j = m - 1;j >= 0;j--){
                if(i == n-1 && j == m - 1){
                    continue;
                }
                int min = Integer.MAX_VALUE;
                if(j+1 < m){
                    min = Math.min(min, dp[i][j+1]);
                }
                if(i+1 < n){
                    min = Math.min(min, dp[i+1][j]);
                }
                if(dungeon[i][j] >= min){
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = min - dungeon[i][j];
                }
            }
        }
        return dp[0][0];
    }
}