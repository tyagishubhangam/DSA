class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp,-1);
        if(s.charAt(0) == '0'){
            return 0;
        }
        if(s.length() == 1){
            return 1;
        }
        return recurse(0,s,dp);
    }

    public static int recurse(int i, String s, int[] dp){
        if(i == s.length()){
            return 1;
        }
        if(i> s.length()){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }

        int n1 = Integer.parseInt(s.substring(i,i+1));
        if(n1 >26 || n1<=0){
            return 0;
        }
        
        
        
        int a = recurse(i+1,s,dp);
        if(n1 > 2){
            return dp[i] = a;
        }
        int b = 0;
        if(i+2 <= s.length()){
            int n2 = Integer.parseInt(s.substring(i,i+2));
            if(n2 <= 26){
                b = recurse(i+2,s,dp);
            }
        }

        return dp[i] = a+b;
        
    }
}