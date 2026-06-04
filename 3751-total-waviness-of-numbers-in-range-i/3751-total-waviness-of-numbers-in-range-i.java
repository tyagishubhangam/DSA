class Solution {
    public int totalWaviness(int num1, int num2) {
        int res = 0;
        for(int i=num1;i<=num2;i++){
            res += countWaviness(i);
        }

        return res;
    }

    public int countWaviness(int n){
        if(n < 100){
            return 0;
        }
        String s = Integer.toString(n);
        int ans = 0;
        for(int i = 1;i<s.length()-1;i++){
            char prev = s.charAt(i-1);
            char mid = s.charAt(i);
            char nxt = s.charAt(i+1);
            if((mid < prev && mid < nxt) || (mid > prev && mid > nxt)){
                ans++;
            }
        }

        return ans;
    }
}