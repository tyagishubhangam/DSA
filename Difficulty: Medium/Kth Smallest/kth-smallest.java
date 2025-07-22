// User function Template for Java

class Solution {
    public static int kthSmallest(int[] arr, int k) {
        // Your code here
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        for(int i=0;i<arr.length;i++){
            pq.offer(arr[i]);
            if(pq.size() > k){
                pq.poll();
            }
        }
        
        return pq.poll();
    }
}
