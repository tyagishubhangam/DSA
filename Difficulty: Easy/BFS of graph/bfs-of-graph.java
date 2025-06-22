class Solution {
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean[] visited = new boolean[adj.size()];
        ArrayList<Integer> res = new ArrayList<>();
        BFS( adj,0,visited, res);
        return res;

        
    }
    
    
    public static void BFS(ArrayList<ArrayList<Integer>> adj, int u, boolean[] visited, ArrayList<Integer> res){
       
        Queue<Integer> queue = new LinkedList<>();
        queue.add(u);
        res.add(u);
        visited[u] = true;
        
        while(queue.size() != 0){
            int x = queue.poll();
            for(int v:adj.get(x)){
                if(!visited[v]){
                    queue.add(v);
                    visited[v] = true;
                    res.add(v);
                }
            }
        }
        
    }
}