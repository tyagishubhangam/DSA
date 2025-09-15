class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] data = new int[n][2];
        for(int i=0;i<n;i++){
            data[i] = new int[]{profits[i], capital[i]};
        }
        Arrays.sort(data, (a,b)->a[1] - b[1]);
        int maxCapital = w;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new SortThePQ());
        int l = 0;
        while(l < n && k > 0){
            while(l < n && w >= data[l][1]){
                pq.offer(data[l]);
                l++;
            }
            if(pq.isEmpty()){
                break;
            }
            w += pq.peek()[0];
            pq.poll();
            k--;
        }
        while(!pq.isEmpty() && k > 0){
            w += pq.poll()[0];
            k--;
        }

        return w;
    }
}

class SortThePQ implements Comparator<int[]>{
    public int compare(int[] a, int[] b){
        

        return b[0] - a[0];
    }
}