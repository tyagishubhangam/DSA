//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {

        // taking input using Scanner class
        Scanner sc = new Scanner(System.in);

        // taking total testcases
        int t = sc.nextInt();

        while (t-- > 0) {

            // taking count of stairs
            int m = sc.nextInt();

            // creating an object of class DynamicProgramming
            Solution obj = new Solution();

            // calling method countWays() of class
            // DynamicProgramming
            System.out.println(obj.countWays(m));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    int countWays(int n) {
        // your code here
        int[] dp = new int[n];
        for(int i=0;i<n;i++){
            dp[i] = -1;
        }
        
        return helper(0,dp,n);
        
    }
    
    public static int helper(int i, int[] dp, int n){
        if(i == n){
            return 1;
        }
        if(i>n){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        
        dp[i] = helper(i+1, dp, n) + helper(i+2, dp, n);
        return dp[i];
    }
}
