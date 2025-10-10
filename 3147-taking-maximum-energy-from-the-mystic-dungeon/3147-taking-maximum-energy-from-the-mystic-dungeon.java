class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        long[] preSum = new long[n];
        for(int i=n-1;i>=n-k;i--){
            preSum[i] = energy[i];
        }

        for(int i=n-k-1;i>=0;i--){
            preSum[i] = preSum[i+k] + energy[i];
        }
        long ans = Long.MIN_VALUE;
        for(int i=n-1;i>=0;i--){
            ans = Math.max(preSum[i], ans);
        }

        return (int)ans;
    }
}