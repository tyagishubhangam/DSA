class Solution {
    int MOD = (int)1e9 + 7;
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int ans = 0;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        for(int day = n - forget + 1;day <= n;day++){
            if(day > 0){
                ans = (ans + solve(day, delay, forget, dp))%MOD;
            }
            
        }

        return ans;
    }

    public int solve(int day, int delay, int forget, int[] dp){
        if(day == 1){
            return 1;
        }
        if(dp[day] != -1){
            return dp[day];
        }

        int res = 0;
        for(int i=day - forget + 1;i<= day-delay;i++){
            if(i > 0){
                res = (res + solve(i,delay, forget, dp))%MOD;
            }
            
        }

        return dp[day] = res;
    }
}