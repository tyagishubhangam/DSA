//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            Solution obj = new Solution();
            long res = obj.subarraySum(arr);

            System.out.println(res);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public long subarraySum(int[] arr) {
        // code here
        long m = (long)Math.pow(10,9) + 7;
        int N = arr.length;
        long ans = 0;
        for(int i=0;i<arr.length;i++){
            long contri = (((((i+1)%m) * ((N-i)%m)) % m) * (arr[i] %m)) % m;
            ans = ((contri % m) + (ans%m)) % m;
        }
        return ans;
    }
}
