//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.numberOfWays(n));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    static int numberOfWays(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        // code here
        return helper(n,dp);
    }
    
    public static int helper(int n, int[] dp){
        if(n<2){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        
        if(dp[n] != -1){
            return dp[n];
        }
        dp[n] = helper(n-1,dp) + helper(n -2, dp);
        return dp[n];
    }
};