//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GfG {

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int m = Integer.parseInt(read.readLine());
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.numberOfPaths(m, n));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    public int numberOfPaths(int m, int n) {
        // Code Here
        int[][] paths = new int[101][101];
        return move(0,0,m,n,paths);
        
        
    }
    
    public static int move(int i, int j, int m, int n,int[][] paths){
        if(i == m-1 || j == n -1 ){
            return 1;
        }
        if(paths[i][j] != 0){
            return paths[i][j];
        }
        paths[i][j] = move(i+1, j, m, n, paths) + move(i, j+1, m, n,paths);
        
        return paths[i][j];
    }
}