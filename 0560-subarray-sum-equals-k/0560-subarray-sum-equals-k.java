class Solution {
    public int subarraySum(int[] arr, int k) {
        Map<Integer, Integer> mpp = new HashMap<>();
        mpp.put(0,1);
        int preSum = 0;
        int n = arr.length;
        int count = 0;
        for(int i=0;i<n;i++){
             preSum += arr[i];

            // Calculate x-k:
            int remove = preSum - k;

            // Add the number of subarrays to be removed:
            count += mpp.getOrDefault(remove, 0);

            // Update the count of prefix sum
            // in the map.
            mpp.put(preSum, mpp.getOrDefault(preSum, 0) + 1);
        }return count;
    }
}