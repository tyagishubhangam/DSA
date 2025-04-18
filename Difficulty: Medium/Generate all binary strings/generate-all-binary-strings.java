//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      Solution obj = new Solution();
      List<String> ans = obj.generateBinaryStrings(n);
      for(String s : ans) System.out.print(s+" ");
      System.out.println();
    
System.out.println("~");
}
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
  public static List<String> generateBinaryStrings(int n) {
    // code here
    List<String> li = new ArrayList<>();
    String str = "";
    generateAns(0, str, li, n);
    return li;

  }
  
  public static void generateAns(int idx, String str,List<String> li, int n){
      if(idx == n){
          li.add(str);
          return;
      }
      
      
      generateAns(idx + 1, str+"0", li, n);
      
      
      if(idx == 0){
          
          generateAns(idx+1, str+"1", li, n);
      }else{
          if(str.charAt(idx-1) != '1'){
              
              generateAns(idx+1, str+"1", li, n);
          }
      }
  }
}
     
     