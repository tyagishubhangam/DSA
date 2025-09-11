class Solution {
    public int minimumDeviation(int[] nums) {
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> b-a);
        int min = Integer.MAX_VALUE;
        int minDev = Integer.MAX_VALUE;
        for(int i : nums){
            if(i % 2 != 0){
                i = i*2;
            }
            min = Math.min(i, min);
            pq.offer(i);
        }

        while(!pq.isEmpty() && pq.peek() % 2 == 0){
            int x = pq.poll();
            minDev = Math.min(minDev, x - min);
            min = Math.min(min, x/2);
            pq.offer(x/2);
        }
        minDev = Math.min(minDev, pq.peek() - min);

        return minDev;

    }
}