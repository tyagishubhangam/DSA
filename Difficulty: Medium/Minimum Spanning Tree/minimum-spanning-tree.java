class Solution {
    public int spanningTree(int V, int[][] edges) {
        // code here
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(new int[]{edge[2], edge[1]});
            adj.get(edge[1]).add(new int[]{edge[2], edge[0]});

        }
        boolean[] visited = new boolean[V];
        PriorityQueue<int[]> pq = new PriorityQueue<>(new SortThePQ());
        pq.offer(new int[]{0,0});
        int res = 0;
        while(!pq.isEmpty()){
            int[] tmp = pq.poll();
            int wt = tmp[0];
            
            int u = tmp[1];
            if(visited[u]){
                continue;
            }
            res += wt;
            visited[u] = true;
            for(int[] child : adj.get(u)){
                int v = child[1];
                int weigh = child[0];
                if(!visited[v]){
                   pq.offer(new int[]{weigh, v});
                }
            }
            
        }
        return res;
    }
}

class SortThePQ implements Comparator<int[]>{
    public int compare(int[] a, int[] b){
        return a[0] - b[0];
    }
}
