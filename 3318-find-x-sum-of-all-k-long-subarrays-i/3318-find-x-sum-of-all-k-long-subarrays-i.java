class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        HashMap<Integer, Integer> hs = new HashMap<>();
        for(int i=0;i<k;i++){
            hs.put(nums[i], hs.getOrDefault(nums[i], 0)+1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(new SortThePQ());
        for(int key : hs.keySet()){
            pq.offer(new int[]{key, hs.get(key)});
            if(pq.size() > x){
                pq.poll();
            }
        }
        int idx = 0;
        while(!pq.isEmpty()){
            int[] tmp = pq.poll();
            ans[idx] += (tmp[0] * tmp[1]);
        }
        idx++;
        int i = 0;
        int j = k;
        while(j < n){
            hs.put(nums[i], hs.get(nums[i])-1);
            hs.put(nums[j], hs.getOrDefault(nums[j], 0)+1);
            for(int key : hs.keySet()){
                pq.offer(new int[]{key, hs.get(key)});
                if(pq.size() > x){
                    pq.poll();
                }
            }
            while(!pq.isEmpty()){
                int[] tmp = pq.poll();
                ans[idx] += (tmp[0] * tmp[1]);
            }
            j++;
            i++;
            idx++;

        }
        return ans;
    }
}

class SortThePQ implements Comparator<int[]>{
    public int compare(int[] a, int[] b){
        if(a[1] == b[1]){
            return a[0] - b[0];
        }

        return a[1] - b[1];
    }
}