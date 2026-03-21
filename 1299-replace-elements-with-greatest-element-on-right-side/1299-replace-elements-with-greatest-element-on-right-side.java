class Solution {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int maxRight = arr[n-1];
        int[] ans = new int[n];
        ans[n-1] = -1;
        for(int i=n-2;i>=0;i--){
            ans[i] = Math.max(maxRight, arr[i+1]);
            maxRight = Math.max(arr[i], maxRight);
        }

        return ans;
    }
}