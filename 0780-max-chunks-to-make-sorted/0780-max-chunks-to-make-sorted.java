class Solution {
    public int maxChunksToSorted(int[] arr) {

        int ans = 0, currMax = 0;
        for(int i=0;i<arr.length;i++){
            currMax = Math.max(currMax, arr[i]);
            if(currMax == i){
                ans++;
            }
        }
        return ans;
        
    }
}