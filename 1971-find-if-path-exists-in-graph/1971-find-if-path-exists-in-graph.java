class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        DFS(adj, source,visited);
        return visited[destination];
        
    }

    public static void DFS(List<List<Integer>> adj, int u, boolean[] visited){
        if(visited[u]){
            return;
        }

        visited[u] = true;
        for(int v : adj.get(u)){
            if(!visited[v]){
                DFS(adj, v, visited);
            }
        }
    }
}