//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        while (testCases-- > 0) {
            int capacity = Integer.parseInt(br.readLine());
            String[] valInput = br.readLine().split(" ");
            String[] wtInput = br.readLine().split(" ");

            int[] val = new int[valInput.length];
            int[] wt = new int[wtInput.length];

            for (int i = 0; i < valInput.length; i++) {
                val[i] = Integer.parseInt(valInput[i]);
            }

            for (int i = 0; i < wtInput.length; i++) {
                wt[i] = Integer.parseInt(wtInput[i]);
            }

            System.out.println(Solution.knapsack(capacity, val, wt));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    static int knapsack(int W, int val[], int wt[]) {
        // code here
        int[][] dp = new int[val.length][W+1];
        for(int i=0;i<val.length;i++){
            for(int j=0;j<=W;j++){
                dp[i][j] = -1;
            }
        }
        
        return helper(val.length -1, W,dp,val,wt);
        
    }
    
    public static int helper(int i, int w, int[][] dp, int[] val, int[] wt){
        if(w<0){
            return Integer.MIN_VALUE;
        }
        
        if(i<0 || w == 0){
            return 0;
        }
        
        if(dp[i][w] != -1){
            return dp[i][w];
        }
        dp[i][w] = Math.max(helper(i-1,w,dp,val,wt), val[i] + helper(i-1, w - wt[i],dp,val,wt));
        return dp[i][w];
    }
}
