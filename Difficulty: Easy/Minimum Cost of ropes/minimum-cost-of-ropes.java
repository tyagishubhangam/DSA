class Solution {
    public static int minCost(int[] arr) {
        // code here
        int n = arr.length;
        if(n < 2){
            return 0;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            pq.offer(arr[i]);
        }
        int minCost = 0;
        while(pq.size() > 1){
            int len = pq.poll() + pq.poll();
            minCost += len;
            pq.offer(len);
        }
        return minCost;
    }
}