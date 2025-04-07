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
            int ans = sln.countFreq(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    int countFreq(int[] arr, int target) {
        // code here
        int n = arr.length;
        int l = 0;
        int r = n - 1;
        int fo = -1;
        int lo = -1;
        while(l<=r){
            int mid = (l + r) / 2;
            if(arr[mid] == target){
                if(mid == 0){
                    fo = 0;
                    break;
                }else{
                    if(arr[mid] != arr[mid - 1]){
                        fo = mid;
                        break;
                    }else{
                        r = mid - 1;
                    }
                }
            }else{
                if(arr[mid] > target){
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }
        }
        
        l = 0;
        r = n - 1;
        while(l<=r){
            int mid = (l + r) / 2;
            if(arr[mid] == target){
                if(mid == n - 1){
                    lo = n - 1;
                    break;
                }else{
                    if(arr[mid] != arr[mid + 1]){
                        lo = mid;
                        break;
                    }else{
                        l = mid + 1;
                    }
                }
            }else{
                if(arr[mid] >target){
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }
        }
        if(fo == -1){
            return 0;
        }
        return (lo - fo + 1);
    }
}
