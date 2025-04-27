//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                String temp[] = br.readLine().trim().split(" ");
                arr[i][0] = Integer.parseInt(temp[0]);
                String x = temp[1];
                arr[i][1] = Integer.parseInt(x);
            }
            Solution obj = new Solution();
            boolean ans = obj.canAttend(arr);
            if (ans)
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
}
// } Driver Code Ends


class Solution {
    static boolean canAttend(int[][] arr) {
        int n = arr.length;
        if(n == 1){
            return true;
        }
        // Your code here
        Arrays.sort(arr, new SortByEnd());
        int prev = arr[0][1];
        for(int i=1;i<n;i++){
            if(prev > arr[i][0]){
                return false;
            }
            prev = arr[i][1];
        }
        return true;
        
        
    }
}

class SortByEnd implements Comparator<int[]>{
    public int compare(int[] a, int[] b){
        return a[1] - b[1];
    }
}