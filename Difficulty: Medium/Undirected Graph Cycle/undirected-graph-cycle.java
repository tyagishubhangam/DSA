class Solution {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        boolean[] visited = new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i] && DFS(adj, i, visited, -1)){
                return true;
            }
        }
        
        return false;
    }
    
    public static boolean DFS(List<List<Integer>> adj, int u, boolean[] visited,int parent){
        
        visited[u] = true;
        
        for(int v : adj.get(u)){
            if(v == parent){
                continue;
            }
            if(visited[v]) {
                return true;
            }
            if(DFS(adj, v, visited,u)){
                return true;
            }
            
        }
        return false;
    }
}