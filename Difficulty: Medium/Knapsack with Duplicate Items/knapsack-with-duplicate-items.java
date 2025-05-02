//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int W = Integer.parseInt(in.readLine().trim());
            String line2[] = in.readLine().trim().split(" ");
            int N = line2.length;
            int val[] = new int[N];
            for (int i = 0; i < N; i++) val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split(" ");
            int wt[] = new int[N];
            for (int i = 0; i < N; i++) wt[i] = Integer.parseInt(line3[i]);

            Solution ob = new Solution();
            System.out.println(ob.knapSack(val, wt, W));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int knapSack(int val[], int wt[], int capacity) {
        int[][] dp = new int[val.length][capacity+1];
        for(int i=0;i<val.length;i++){
            for(int j=0;j<=capacity;j++){
                dp[i][j] = -1;
            }
        }
        // code here
        return recurse(val.length - 1,capacity,val,wt,dp);
        
    }
    
    public static int recurse(int i, int cp, int[] val, int[] capacity, int[][] dp){
        if(cp<0){
            return Integer.MIN_VALUE;
        }
        if(i<0 || cp == 0){
            return 0;
        }
        if(dp[i][cp] != -1){
            return dp[i][cp];
        }
        int ans = recurse(i-1,cp,val,capacity,dp);
        if(cp>=capacity[i]){
            ans = Math.max(ans,val[i]+recurse(i,cp - capacity[i],val,capacity,dp));
        }
        return dp[i][cp] = ans;
    }
}