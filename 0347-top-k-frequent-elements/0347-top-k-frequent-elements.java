class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> hs = new HashMap<>();
        for(int i=0;i<n;i++){
            hs.put(nums[i], hs.getOrDefault(nums[i],0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(new SortThePQ());
        for(int i:hs.keySet()){
            pq.offer(new int[]{i, hs.get(i)});
            if(pq.size() > k){
                pq.poll();
            }
        }
        int[] res = new int[pq.size()];
        for(int i=0;i<res.length;i++){
            res[i] = pq.poll()[0];
        }

        return res;
        
    }
}

class SortThePQ implements Comparator<int[]>{
    public int compare(int[] a1, int[] a2){
        if(a1[1] == a2[1]){
            return a2[0] - a1[0];
        }

        return a1[1] - a2[1];
    }
}