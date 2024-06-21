//{ Driver Code Starts
import java.util.*;

class MaxLenZeroSumSub
{

    // Returns length of the maximum length subarray with 0 sum

    // Drive method
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            GfG g = new GfG();
            System.out.println(g.maxLen(arr, n));
            T--;
        }
    }
}
// } Driver Code Ends


class GfG
{
    int maxLen(int arr[], int n)
    {
        int sum = 0;
        int res = 0;
        HashMap<Integer, Integer> hs = new HashMap<>();
        for(int i = 0;i<n;i++){
            sum = sum+arr[i];
            if(sum == 0){
                res = i+1;
            }else if(hs.containsKey(sum)){
                res = Math.max(res,i-hs.get(sum));
            }else{
                hs.put(sum,i);
            }
        }
        return res;
    }
}