//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.aggressiveCows(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    public static int aggressiveCows(int[] stalls, int k) {
        // code here
        Arrays.sort(stalls);
        int n = stalls.length;
        int l = 0;
        int r = stalls[n-1];
        while(l <= r){
            int mid = (l + r) / 2;
            boolean isValid = checker(stalls, mid, k);
            if(!isValid){
                r = mid - 1;
            }else{
                if(!checker(stalls, mid+1, k)){
                    return mid;
                }else{
                    l = mid + 1;
                }
            }
        }
        return 1;
    }
    
    public static boolean checker(int[] stalls, int m, int k){
        int cnt = 1;
        int prev = stalls[0];
        for(int i=1;i<stalls.length;i++){
            if((stalls[i] - prev) >= m){
                cnt++;
                prev = stalls[i];
            }
        }
        return cnt >= k;
    }
}