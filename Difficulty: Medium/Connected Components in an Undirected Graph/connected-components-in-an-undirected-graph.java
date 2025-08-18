
class Solution {
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        // code here
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] visited = new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                ArrayList<Integer> dfs = new ArrayList<>();
                DFS(adj, i, visited, dfs);
                result.add(dfs);
                
            }
            
        }
        
        return result;
        
        
    }
    
    public static void DFS(List<List<Integer>> adj, int u, boolean[] visited, ArrayList<Integer> tmp){
        
        if(visited[u]){
            return ;
        }
        visited[u] = true;
        tmp.add(u);
        
        for(int v : adj.get(u)){
            if(visited[v]){
                continue;
            }
            
            DFS(adj, v, visited, tmp);
        }
 
    }
}