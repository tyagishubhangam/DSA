//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String s[] = in.readLine().trim().split(" ");
            int[] arr = new int[s.length];
            for (int i = 0; i < s.length; i++) arr[i] = Integer.parseInt(s[i]);

            Solution ob = new Solution();
            out.println(ob.cutRod(arr));

            out.println("~");
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {
    public int cutRod(int[] price) {
        // code here
        
        int[] mem = new int[price.length + 1];
        Arrays.fill(mem, -1);
        return getAns(price.length, price, mem);
        
    }
    
    public static int getAns(int i, int[] price, int[] mem){
        if(i == 0){
            return 0;
        }
        
        if(mem[i] != -1){
            return mem[i];
        }
        
        for(int j=1;j<=i;j++){
            mem[i] = Math.max(mem[i], price[j-1] + getAns(i-j, price, mem));
        }
        
        return mem[i];
    }
}