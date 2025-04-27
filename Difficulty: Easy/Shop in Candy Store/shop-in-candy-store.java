//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int K = Integer.parseInt(input_line[1]);
            input_line = read.readLine().trim().split("\\s+");
            int candies[]= new int[N];
            for(int i = 0; i < N; i++)
                candies[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            ArrayList<Integer> cost = ob.candyStore(candies,N,K);
            System.out.println(cost.get(0)+" "+cost.get(1));
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static ArrayList<Integer> candyStore(int candies[], int N, int K) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        int n = candies.length;
        if(K == 0){
            int sm = 0;
            for(int i=0;i<n;i++){
                sm += candies[i];
            }
            ans.add(sm);
            ans.add(sm);
            return ans;
        }
        Arrays.sort(candies);
        int minCost = 0;
        int maxCost = 0;
        int buy = 0;
        int free = n - 1;
        while(buy<=free){
            minCost += candies[buy];
            buy++;
            free -= K;
            
        }
        buy = n - 1;
        free = 0;
        while(buy >= free){
            maxCost += candies[buy];
            buy--;
            free += K;
        }
        ans.add(minCost);
        ans.add(maxCost);
        return ans;
    }
}