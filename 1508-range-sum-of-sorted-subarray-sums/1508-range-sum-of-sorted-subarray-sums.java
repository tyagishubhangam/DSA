class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int MOD = (int)1e9 + 7;
        long[] preSum = new long[n];
        preSum[0] = (long) nums[0];
        for(int i=1;i<n;i++){
            preSum[i]  = preSum[i-1] + (long) nums[i];
        }
        List<Long> sums = new ArrayList<>();

        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(i == 0){
                    sums.add(preSum[j]);
                }else{
                    sums.add(preSum[j] - preSum[i-1]);
                }
            }
        }
        Collections.sort(sums, (a,b)->Long.compare(a,b));
        long res = 0;
        for(int i=left-1;i<right;i++){
            res = (res % MOD + sums.get(i) % MOD) % MOD;
        }

        return (int)res;
        
    }
}