class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] suffArr = new int[n];
        suffArr[n - 1] = prices[n - 1];
        for(int i=n-2;i>=0;i--){
            suffArr[i] = Math.max(prices[i], suffArr[i + 1]);
        }
        int profit = 0;
        for(int i=0;i<n;i++){
            profit = Math.max(profit, suffArr[i] - prices[i]);
        }
        return profit;
    }
}