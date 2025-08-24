class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        if(n == 1){
            return 0;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(new SortThePQ());
        boolean[] visited = new boolean[n];
        int result = 0;
        pq.offer(new int[]{0,0});
        while(!pq.isEmpty()){
            int[] tmp = pq.poll();
            if(visited[tmp[1]]){
                continue;
            }
            visited[tmp[1]] = true;
            result += tmp[0];
            for(int i=0;i<n;i++){
                if(i != tmp[1] && !visited[i]){
                    int[] a = points[tmp[1]];
                    int[] b = points[i];
                    int dist = Math.abs(a[0] - b[0]) + Math.abs(a[1]-b[1]);
                    pq.offer(new int[]{dist,i});
                }
            }
        }

        return result;

    }
}

class SortThePQ implements Comparator<int[]>{
    public int compare(int[] a, int[] b){
        return a[0] - b[0];
    }
}