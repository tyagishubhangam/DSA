
class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            Pair tmp = new Pair(w,v);
            adj.get(u).add(tmp);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(new SortPriorityQueue());
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        pq.add(new Pair(0,src));
        
        while(!pq.isEmpty()){
            Pair tmp = pq.poll();
            int u = tmp.getValue();
            int wu = tmp.getKey();
            for(Pair pr:adj.get(u)){
                int v = pr.getValue();
                int w = pr.getKey();
                int totalDist = wu + w;
                if(dist[v] > totalDist){
                    pq.add(new Pair(totalDist,v));
                    dist[v] = totalDist;
                }
            }
        }
        
        return dist;
        
    }
}

 class Pair{
    private int key;
    private int value;
    
    public Pair(int key, int value){
        this.key = key;
        this.value = value;
    }
    
    public int getKey(){
        return this.key;
    }
    
    public int getValue(){
        return this.value;
    }
    
}

 class SortPriorityQueue implements Comparator<Pair>{
    public int compare(Pair p1, Pair p2){
        int dis1 = p1.getKey();
        int dis2 = p2.getKey();
        int n1 = p1.getValue();
        int n2 = p2.getValue();
        if(dis1 != dis2){
            return dis1 - dis2;
        }
        return n1 - n2;
    }
}