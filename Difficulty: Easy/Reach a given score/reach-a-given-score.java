//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        while(t > 0)
        {
            int n = in.nextInt();
            Geeks obj = new Geeks();
            System.out.println(obj.count(n));
            t--;
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// Complete this function!

class Geeks {
    public long count(int n) {
        // Add your code here.
        int[] points = {3,5,10};
        int[][] dp = new int[n+1][4];
        for(int i=0;i<4;i++){
            dp[0][i] = 1;
        }
        
        for(int i=1;i<=n;i++){
            for(int j=2;j>=0;j--){
                if(i-points[j] >=0){
                    dp[i][j] = dp[i-points[j]][j] + dp[i][j+1];
                }else{
                    dp[i][j] = dp[i][j+1];
                }
            }
        }
        return dp[n][0];
    }
    
    
}