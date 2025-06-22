class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<Boolean> visited = new ArrayList<>();
        for(int i = 0;i<adj.size();i++){
            visited.add(false);
        }
        DFS(adj,0,visited,res);
        return res;
    }
    
    public static void DFS(ArrayList<ArrayList<Integer>> adj,int u, ArrayList<Boolean> visited, ArrayList<Integer> res){
        if(visited.get(u)){
            return;
        }
        visited.set(u,true);
        res.add(u);
        
        for(int v:adj.get(u)){
            if(!visited.get(v)){
                DFS(adj,v,visited,res);
            }
        }
    }
}