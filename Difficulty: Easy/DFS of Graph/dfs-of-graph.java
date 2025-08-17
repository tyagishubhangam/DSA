class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int n = adj.size();
        boolean[] visited = new boolean[n];
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!visited[i]){
                doDFS(adj, i, visited, res);
            }
        }
        return res;
        
    }
    
    public static void doDFS(ArrayList<ArrayList<Integer>> adj, int u,
    boolean[] visited, ArrayList<Integer> res){
        if(visited[u]){
            return ;
        }
        res.add(u);
        visited[u] = true;
        for(int v:adj.get(u)){
            if(!visited[v]){
                doDFS(adj, v, visited, res);
            }
        }
        
    }
}