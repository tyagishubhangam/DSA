class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            
        }
        
        boolean[] visited = new boolean[V];
        boolean[] visitedInRecurse = new boolean[V];
        
        for(int i=0;i<V;i++){
            if(!visited[i] && checkCycle(adj,i,visited,visitedInRecurse)){
                return true;
            }
        }
        
        return false;
    }
    
    public static boolean checkCycle(
        List<List<Integer>> adj,
        int u,
        boolean[] visited,
        boolean[] visitedInRecurse
    ){
        visited[u] = true;
        visitedInRecurse[u] = true;
        
        for(int v:adj.get(u)){
            if(!visited[v] && checkCycle(adj,v,visited,visitedInRecurse)){
                return true;
            }
            if(visitedInRecurse[v]){
                return true;
            }
            
            
        }
        visitedInRecurse[u] = false;
        
        return false;
    }
}