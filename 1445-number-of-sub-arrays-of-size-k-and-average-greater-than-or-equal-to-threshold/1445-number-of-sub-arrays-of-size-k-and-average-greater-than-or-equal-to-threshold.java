class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sm = 0;
        int n = arr.length;
        int ans = 0;
        for(int i=0;i<k;i++){
            sm += arr[i];
        }
        if(sm / k >= threshold){
            ans++;
        }
        int i=0;
        int j = k;
        while(j<n){
            sm = sm - arr[i] + arr[j];
            if(sm/k >= threshold){
                ans++;
            }
            i++;
            j++;
        }
        return ans;
    }
}