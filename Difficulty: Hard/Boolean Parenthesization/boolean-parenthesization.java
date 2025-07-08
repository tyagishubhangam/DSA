// User function Template for Java
class Solution {
    static int countWays(String s) {
        // code here
        int n = s.length();
        int[][][] dp = new int[n][n][2];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j][0] = -1;
                dp[i][j][1] = -1;
            }
        }
        
        return recurse(s,0,n-1,1,dp);
        
    }
    
    public static int recurse(String s, int i, int j, int isTrue, int[][][] dp){
        if(i>j){
            return 0;
        }
        
        if(i == j){
            if(isTrue == 1){
                return s.charAt(i) == 'T'?1:0;
            }else{
                return s.charAt(i) == 'F'?1:0;
            }
        }
        if(dp[i][j][isTrue] != -1){
            return dp[i][j][isTrue];
        }
        int ways = 0;
        for(int k=i+1;k<j;k=k+2){
            int lT = recurse(s,i,k-1,1,dp);
            int rT = recurse(s,k+1,j,1,dp);
            int lF = recurse(s,i,k-1,0,dp);
            int rF = recurse(s,k+1,j,0,dp);
            
            char ch = s.charAt(k);
            if(ch == '&'){
                if(isTrue == 1){
                    ways += (lT * rT);
                }else{
                    ways += (lT * rF) + (lF * rT) + (lF * rF);
                }
            }else if(ch == '|' ){
                if(isTrue != 1){
                    ways += (lF * rF);
                }else{
                    ways += (lT * rF) + (lF * rT) + (lT * rT);
                }
            }else{
                if(isTrue != 1){
                    ways += (lT * rT) + (lF * rF);
                }else{
                    ways += (lT * rF) + (lF * rT);
                }
            }
        }
        
        return dp[i][j][isTrue] = ways;
    }
}