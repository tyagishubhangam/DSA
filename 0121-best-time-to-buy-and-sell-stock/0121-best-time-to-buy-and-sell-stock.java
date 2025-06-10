class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] suffMax = new int[n];
        suffMax[n - 1] = prices[n - 1];
        for(int i=n-2;i>=0;i--){
            suffMax[i] = Math.max(prices[i],suffMax[i + 1]);
        }
        int profit = 0;

        for(int i=0;i<n;i++){
            profit = Math.max(profit, suffMax[i] - prices[i]);
        }
        return profit;
    }
}