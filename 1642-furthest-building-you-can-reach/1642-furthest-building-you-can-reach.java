class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b - a);
        int i = 0;
        for(i=1;i<n;i++){
            int diff = heights[i] - heights[i-1];
            if(diff <= 0){
                continue;
            }
            if(bricks >= diff){
                pq.offer(diff);
                bricks -= diff;
            }else{
                if(ladders <= 0){
                    break;
                }
                if(!pq.isEmpty() && pq.peek() > diff){
                    bricks += pq.poll();
                    bricks -= diff;
                    pq.offer(diff);
                }
                ladders--;
            }

        }
        return i-1;
    }
}