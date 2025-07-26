// User function Template for Java

class Solution {
    public static long sumBetweenTwoKth(long A[], long N, long K1, long K2) {
        // Your code goes here
        int n = A.length;
        PriorityQueue<Long> pq = new PriorityQueue<>(new SortThePQ());
        for(int i=0;i<n;i++){
            pq.offer(A[i]);
            if(pq.size() >= (K2)){
                pq.poll();
            }
        }
        long res = 0;
        while(pq.size() > K1){
            res += pq.poll();
        }
        
        return res;
    }
}

class SortThePQ implements Comparator<Long> {
    public int compare(Long a, Long b){
        return b.compareTo(a);
    }
}
