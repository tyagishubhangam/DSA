class Solution {
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
        }
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                DFS(adj, i, visited, result);
            }
        }
        Collections.reverse(result);
        
        return result;
    }
    
    public static void DFS(List<List<Integer>> adj, int u, boolean[] visited, ArrayList<Integer> result){
        visited[u] = true;
        for(int v : adj.get(u)){
            if(!visited[v]){
                DFS(adj, v, visited, result);
            }
        }
        
        result.add(u);
        
    }
}