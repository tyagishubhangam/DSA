class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        int n = happiness.length;
        
        long ans = 0;
        Arrays.sort(happiness);
        int idx = n - 1;
        while(k-->0){
            ans += Math.max(happiness[idx]-(n-1-idx), 0);
            idx--;
        }
        return ans;
    }
}