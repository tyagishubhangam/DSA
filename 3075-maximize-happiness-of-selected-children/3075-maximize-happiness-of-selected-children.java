class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        int n = happiness.length;
        long dec = 0;
        long ans = 0;
        Arrays.sort(happiness);
        for(int i=n-1;i>=0;i--){
            if(k-- <= 0){
                break;
            }
            if(happiness[i] - dec <= 0){
                break;
            }
            ans += happiness[i] - dec;

            dec++;
        }
        return ans;
    }
}