class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> hs = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0] - b[0]);
        for(int i : arr){
            hs.put(i, hs.getOrDefault(i,0)+1);
        }

        for(int key : hs.keySet()){
            pq.offer(new int[]{hs.get(key), key});
        }
        while(k > 0){
            int[] top = pq.poll();
            if(k >= top[0]){
                k-= top[0];
            }else{
                k--;
                top[0]--;
                if(top[0]>0){
                    pq.offer(top);
                }
            }

        }

        return pq.size();
    }
}