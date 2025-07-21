// User function Template for Java

class Solution {
    // Function to find the minimum number of platforms required at the
    // railway station such that no train waits.
    static int findPlatform(int arr[], int dep[]) {
        // add your code here
        Arrays.sort(arr);
        Arrays.sort(dep);
        int n = arr.length;
        int cnt = 0;
        int maxCnt = 0;
        int i = 0;
        int j = 0;
        while(i<n && j < n){
            if(arr[i] <= dep[j]){
                cnt++;
                i++;
            }else{
                cnt--;
                j++;
            }
            maxCnt = Math.max(cnt, maxCnt);
        }
        return maxCnt;
    }
}
