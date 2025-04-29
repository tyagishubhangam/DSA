class Solution {
    public int coinChange(int[] coins, int amount) {
        long[] ans = new long[amount+ 1];
        ans[0] = 0;
        for(int i=1;i<=amount;i++){
            ans[i] = Integer.MAX_VALUE;
            for(int coin:coins){
                if(coin <= i){
                    ans[i] = Math.min(ans[i], 1+ ans[i-coin]);
                }
            }
        }
        return ans[amount] <= amount? (int)ans[amount]:-1;
    }
}