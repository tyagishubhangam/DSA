//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int[] nums = IntArray.input(br, n);

            Solution obj = new Solution();
            int res = obj.LongestBitonicSequence(n, nums);

            System.out.println(res);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends



class Solution {
    public static int LongestBitonicSequence(int n, int[] nums) {
        // code here
        int[] lis = LIS(n, nums);
        int[] lds = new int[nums.length];
        lds[n-1] = 1;
        int ans = 0;
        for(int i=n-1;i>=0;i--){
            lds[i] = 1;
            for(int j=i+1;j<n;j++){
                if(nums[i] > nums[j]){
                    lds[i] = Math.max(lds[i], 1+lds[j]);
                }
            }
            if(lis[i]>1 && lds[i]>1){
                 ans = Math.max(ans, lis[i] + lds[i] -1);
            }
           
        }
        // System.out.println(lis[n-1]);
        
        if(lis[n-1] == n || lds[0] == n){
            return 0;
        }
        return ans;
        
    }
    
    public static int[] LIS(int n, int[] nums){
        int[] lis = new int[nums.length];
        lis[0] = 1;
        for(int i=1;i<nums.length;i++){
            lis[i] = 1;
            for(int j=0;j<i;j++){
                if(nums[i] > nums[j]){
                    lis[i] = Math.max(lis[i], 1+ lis[j]);
                }
            }
        }
        return lis;
    }
}
