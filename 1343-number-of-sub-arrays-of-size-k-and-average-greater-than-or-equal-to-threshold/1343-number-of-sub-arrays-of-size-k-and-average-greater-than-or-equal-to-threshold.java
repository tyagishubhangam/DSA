class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int n = arr.length;
        int cnt = 0;
        int currSum = 0;
        int l = 0;
        int r = k;
        for(int i=0;i<k;i++){
            currSum += arr[i];
        }
        if(currSum / k >= threshold){
            cnt++;
        }
        while(r < n){
            currSum -= arr[l];
            currSum += arr[r];
            if(currSum / k >= threshold){
                cnt++;
            }
            l++;
            r++;
        }
        return cnt;
    }
}