class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new SortThePQ());
        for(int i=0;i<nums.length;i++){
            pq.offer(new int[]{nums[i], i});
        }
        while(k-- > 0){
            int[] tmp = pq.poll();
            tmp[0] = tmp[0] * multiplier;
            pq.offer(tmp);
        }
        while(!pq.isEmpty()){
            int[] tmp = pq.poll();
            nums[tmp[1]] = tmp[0];
        }

        return nums;
        
    }
}

class SortThePQ implements Comparator<int[]>{
    public int compare(int[] a, int[] b){
        if(a[0] == b[0]){
            return a[1] - b[1];
        }

        return a[0] - b[0];
    }
}