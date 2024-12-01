//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        int l = 0, r = 0, maxLen = 0;
        int n = s.length();
        HashMap<Character, Integer> hs = new HashMap<>();
        while(r < n){
            char ch = s.charAt(r);
            hs.put(ch, hs.getOrDefault(ch,0) + 1);
            if(hs.size() > k){
                hs.put(s.charAt(l), hs.get(s.charAt(l)) - 1);
                if(hs.get(s.charAt(l)) == 0){
                    hs.remove(s.charAt(l));
                }
                l++;
                
            }if(hs.size() == k){
                maxLen = Math.max(maxLen, r - l + 1);
            }
            r++;
        }
        return maxLen == 0 ? -1: maxLen;
    }
}