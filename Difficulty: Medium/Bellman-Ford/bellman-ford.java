// User function Template for Java

class Solution {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        // code here
        int[] dist = new int[V];
        Arrays.fill(dist, (int)1e8);
        dist[src] = 0;
        
        
        for(int i=1;i<V;i++){
            for(int[] edge:edges){
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];
                
                if(dist[u] != (int)1e8 && (dist[u] + w) < dist[v]){
                    dist[v] = dist[u] + w;
                }
            }
        }
        
        for(int[] edge:edges){
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];
                
                if(dist[u] != (int)1e8 && (dist[u] + w) < dist[v]){
                    
                    return new int[]{-1};
                }
            }
            
            return dist;
        
    }
}
