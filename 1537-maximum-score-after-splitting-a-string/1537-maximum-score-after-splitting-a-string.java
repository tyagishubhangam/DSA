class Solution {
    public int maxScore(String s) {
        int n = s.length();
        int[] zeroSum = new int[n];
        int[] oneSum = new int[n];
        if(s.charAt(0) == '0'){
            zeroSum[0] = 1;
        }
        if(s.charAt(n-1) == '1'){
            oneSum[n-1] = 1;
        }
        
        for(int i=1;i<n;i++){
            if(s.charAt(i) == '0'){
                zeroSum[i] = zeroSum[i-1]+1;
            }else{
                zeroSum[i] = zeroSum[i-1];
            }
        }
        for(int i=n-2;i>=0;i--){
            if(s.charAt(i) == '1'){
                oneSum[i] = oneSum[i+1] + 1;
            }else{
                oneSum[i] = oneSum[i+1];
            }
        }
        int ans = 0;
        for(int i=0;i<n-1;i++){
            ans = Math.max(ans, zeroSum[i]+oneSum[i+1]);
        }
        return ans;


    }
}