//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int x = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            int[] arr = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }

            Solution ob = new Solution();
            int[] ans = ob.getFloorAndCeil(x, arr);
            System.out.println(ans[0] + " " + ans[1]);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends

 
// User function Template for Java

class Solution {
    public int[] getFloorAndCeil(int x, int[] arr) {
        Arrays.sort(arr);
        int p = Integer.MIN_VALUE;
        int q = Integer.MAX_VALUE;
        for(int i=0; i<arr.length;i++){
            if(arr[i] <= x){
                p = Math.max(p,arr[i]);
            }
            if(arr[i] >= x) {
                q = Math.min(q, arr[i]);
            }
        }
        if(p == Integer.MIN_VALUE){
            p = -1;
        }
        if(q == Integer.MAX_VALUE){
            q = -1;
        }
        int res[] = new int[2];
        res[0] = p;
        res[1] = q;
        return res;
    }
}
