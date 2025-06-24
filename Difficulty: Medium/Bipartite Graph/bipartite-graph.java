class Solution {
    public boolean isBipartite(int V, int[][] edges) {
        // Code here
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }
        int[] colorState = new int[V];
        Arrays.fill(colorState, -1);
        for(int i=0;i<V;i++){
            if(colorState[i] == -1 && bipartiteDFS(adj,i,0,colorState) == false){
                return false;
            }
        }
        
        return true;
        
    }
    
    public static boolean bipartiteDFS(List<List<Integer>> adj, int u, int currColor, int[] colorState){
        
        colorState[u] = currColor;
        for(int v:adj.get(u)){
            if(colorState[v] == currColor){
                return false;
            }
            if(colorState[v] == -1 && bipartiteDFS(adj, v, 1 - currColor, colorState) == false ){
                return false;
            }
        }
        
        return true;
    }
}