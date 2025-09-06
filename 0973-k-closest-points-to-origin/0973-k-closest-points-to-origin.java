class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new SortThePQ());
        for(int[] point : points){
            pq.offer(new int[]{point[0], point[1], (int)Math.pow(point[0],2) + (int)Math.pow(point[1],2)});
            if(pq.size() > k){
                pq.poll();
            }
        }
        int[][] result = new int[pq.size()][2];
        int i=0;
        while(!pq.isEmpty()){
            int[] point = pq.poll();
            result[i][0] = point[0];
            result[i][1] = point[1];
            i++;
        }

        return result;
    }
}

class SortThePQ implements Comparator<int[]>{
    public int compare(int[] a, int[] b){
        return b[2] - a[2];
    }
}