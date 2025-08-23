class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] time : times){
            int u = time[0];
            int v = time[1];
            int wt = time[2];
            adj.get(u).add(new int[]{v,wt});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(new SortThePQ());
        pq.offer(new int[]{k,0});
        int[] dist = new int[n+1];
        Arrays.fill(dist, (int)1e8);
        dist[k] = 0;
        while(!pq.isEmpty()){
            int[] parent = pq.poll();
            int u = parent[0];
            int wt = parent[1];
            for(int[] child : adj.get(u)){
                int v = child[0];
                int newWt = wt + child[1];
                if(newWt < dist[v]){
                    dist[v] = newWt;
                    pq.offer(new int[]{v,newWt});
                }
            }
        }
        int res = 0;
            for(int i=1;i<=n;i++){
                if(dist[i] >= (int)1e8){
                    return -1;
                }
                res = Math.max(res, dist[i]);
            }
            return res;
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