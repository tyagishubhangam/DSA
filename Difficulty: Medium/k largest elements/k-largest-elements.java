class Solution {
    public ArrayList<Integer> kLargest(int[] arr, int k) {
        // Your code here
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)-> a-b);
        for(int i=0;i<n;i++){
            pq.offer(arr[i]);
            if(pq.size() > k){
                pq.poll();
            }
        }
        
        while(!pq.isEmpty()){
            res.add(pq.poll());
        }
        Collections.sort(res, (a,b)->b-a);
        return res;
    }
}
