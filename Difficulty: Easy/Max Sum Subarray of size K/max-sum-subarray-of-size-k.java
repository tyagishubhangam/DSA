// User function Template for Java

class Solution {
    public int maximumSumSubarray(int[] arr, int k) {
        // Code here
        int n = arr.length;
        int sum = 0;
        for(int i=0;i<k;i++){
            sum += arr[i];
        }
        int maxSum = sum;
        int j = 0;
        for(int i=k;i<n;i++){
            sum = sum - arr[j] + arr[i];
            maxSum = Math.max(maxSum, sum);
            j++;
        }
            return maxSum;

    }
    
}