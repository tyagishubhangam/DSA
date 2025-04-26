class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 1){
            return 0;
        }
        int[] suffPrices = new int[prices.length];
        suffPrices[prices.length - 1] = prices[prices.length - 1];
        for(int i=prices.length - 2;i>=0;i--){
            suffPrices[i] = Math.max(suffPrices[i+1], prices[i]);
        }
        int profit = Integer.MIN_VALUE;
        for(int i=0;i<prices.length-1;i++){
            profit = Math.max(profit,  suffPrices[i+1] - prices[i] );
        }

        return profit<0?0: profit;
    }
}