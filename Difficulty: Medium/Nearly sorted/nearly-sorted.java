class Solution {
    public void nearlySorted(int[] arr, int k) {
        // code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = arr.length;
        int idx = 0;
        for(int i=0;i<n;i++){
            pq.offer(arr[i]);
            if(pq.size() > k){
                arr[idx] = pq.poll();
                idx++;
            }
        }
        
        while(!pq.isEmpty()){
            arr[idx] = pq.poll();
            idx++;
        }
    }
}
