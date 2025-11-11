class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[] oneFreq = new int[len];
        int[] zeroFreq = new int[len];
        Integer[][][] dp = new Integer[len][m+1][n+1];
        
        for(int i=0;i<len;i++){
            String st = strs[i];
            int cnt = 0;
            for(int j=0;j<st.length();j++){
                cnt += st.charAt(j) - '0';
            }
            oneFreq[i] = cnt;
            zeroFreq[i] = st.length() - cnt;
        }

        return recurse(0, oneFreq, zeroFreq,m,n, dp);

    }

    public int recurse(int i, int[] oneFreq, int[] zeroFreq, int m, int n, Integer[][][] dp){
        if(i >= oneFreq.length){
            return 0;
        }
        if(m<0 || n < 0){
            return Integer.MIN_VALUE;
        }
        if(dp[i][m][n] != null){
            return dp[i][m][n];
        }
        int take = 0;
        if(zeroFreq[i] <= m && oneFreq[i] <= n ){
            take = 1 + recurse(i+1,oneFreq, zeroFreq,m - zeroFreq[i], n - oneFreq[i], dp);
        }
        
        int notTake = recurse(i+1,oneFreq, zeroFreq,m, n, dp );

        return dp[i][m][n] = Math.max(take, notTake);

    } 
}