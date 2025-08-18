class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }
        
        boolean[] visited = new boolean[V];
        boolean[] currRecur = new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(DFS(adj, i, visited, currRecur)){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public static boolean DFS(List<List<Integer>> adj, int u, boolean[] visited, boolean[] currRecur){
        if(visited[u] && currRecur[u]){
            return true;
        }
        
        visited[u] = true;
        currRecur[u] = true;
        
        for(int v:adj.get(u)){
            if(DFS(adj, v, visited, currRecur) && visited[v]){
                return true;
            }
            if(currRecur[v]){
                return true;
            }
            
        }
        currRecur[u] = false;
        return false;
    }
}