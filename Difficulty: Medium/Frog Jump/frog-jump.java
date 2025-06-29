// User function Template for Java
class Solution {
    int minCost(int[] height) {
        // code here
        int n = height.length;
        int[] dp = new int[n];
        Arrays.fill(dp,(int)1e9);
        return recurse(n-1,dp,height);
        
    }
    
    public static int recurse(int i, int[] dp, int[] height){
        
        if(i == 0){
            return 0;
        }
        
        if(dp[i] != (int)1e9){
            return dp[i];
        }
        
        int oneStep = Math.abs(height[i] - height[i-1]) + recurse(i-1,dp,height);
        int twoStep = (int)1e9;
        if(i>1){
             twoStep = Math.abs(height[i] - height[i-2]) + recurse(i-2, dp, height);
        }
        return dp[i] = Math.min(oneStep, twoStep);
         
        
    }
    
    
}