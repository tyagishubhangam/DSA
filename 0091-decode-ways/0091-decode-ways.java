class Solution {
    public int numDecodings(String s) {
        int dp[] = new int[s.length()];
        Arrays.fill(dp, -1);
        int ans = getAns(0,dp,s);
        return ans >=0? ans:0;
    }

    public static int getAns(int i, int[] dp, String s){
        if(i == s.length()){
            return 1;
        }

        if(i> s.length() ){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }

        int n1 = s.charAt(i) - '0';

        if(n1>0 && n1<=9){
            dp[i] = getAns(i+1,dp,s);

            if(i+1 < s.length()){
                int n2 = n1*10 + (s.charAt(i+1) - '0');
                if(n2>=10 && n2<=26){
                    dp[i] +=getAns(i+2,dp,s);
                }
            }
        }

        return dp[i] == -1 ? 0:dp[i];
    }
}