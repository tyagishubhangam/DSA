class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            adj.get(u).add(new Pair(v,wt));
            adj.get(v).add(new Pair(u, wt));
        }
        int[] minDist = new int[V];
        
        Arrays.fill(minDist, (int)1e8);
        minDist[src] = 0;
        
        PriorityQueue<Pair> pq = new PriorityQueue<>(new SortThePQ());
        pq.add(new Pair(src, 0));
        
        while(!pq.isEmpty()){
            Pair tmp = pq.poll();
            int parent = tmp.v;
            int currWt = tmp.wt;
            for(Pair child : adj.get(parent)){
                int v = child.v;
                int newWt = currWt + child.wt;
                if(newWt < minDist[v]){
                    minDist[v] = newWt;
                    pq.offer(new Pair(v, newWt));
                }
            }
        }
        return minDist;
    }
}

class Pair{
    int v;
    int wt;
    Pair(int v, int wt){
        this.v = v;
        this.wt = wt;
    }
}

class SortThePQ implements Comparator<Pair>{
    public int compare(Pair p1, Pair p2){
        if(p1.wt == p2.wt){
            return p1.v - p2.v;
        }
        
        return p1.wt - p2.wt;
    }
}