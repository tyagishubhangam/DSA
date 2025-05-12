class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                dp[i][j] = true;
            }
            
        }
        int ans = 0;
        String str = s.substring(0,1);

        for(int k=1;k<=n;k++){
            int i=0;
            int j = k;
            while(i < n && j < n){
                if((s.charAt(i) == s.charAt(j)) && dp[i+1][j-1]){
                    dp[i][j] = true;
                    if(ans < (j - i + 1)){
                        ans  = j - i + 1;
                        str = s.substring(i, j+1);
                    }
                }else{
                    dp[i][j] = false;
                }
                i++;
                j++;
            }
        }
        System.out.println(ans);
        return str;
    }
}