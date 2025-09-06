class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new SortThePQ());
        long total = 0;
        for(int gift : gifts){
            pq.offer(gift);
        }

        while(k-- > 0){
            int gift = pq.poll();
            int nG = (int)Math.floor(Math.sqrt(gift));
            pq.offer(nG);
        }

        while(!pq.isEmpty()){
            total += pq.poll();
        }
        return total;
    }
}

class SortThePQ implements Comparator<Integer>{
    public int compare(Integer a, Integer b){
        return b - a;
    }
}