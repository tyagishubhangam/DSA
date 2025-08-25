class Solution {
    // Function to find number of strongly connected components in the graph.
    public int kosaraju(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int V = adj.size();
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                topoDFS(i, visited, st, adj);
            }
        }
        Arrays.fill(visited, false);
        
        ArrayList<ArrayList<Integer>> revAdj = new ArrayList<>();
        for(int i=0;i<V;i++){
            revAdj.add(new ArrayList<>());
        }
        for(int i=0;i<V;i++){
            for(int j : adj.get(i)){
                revAdj.get(j).add(i);
            }
        }
        int sccCount = 0;
        while(!st.isEmpty()){
            int i = st.pop();
            if(!visited[i]){
                DFS(i, visited, revAdj);
                sccCount++;
            }
        }
        return sccCount;
    }
    
    public void DFS(int u, boolean[] visited, ArrayList<ArrayList<Integer>> revAdj){
        if(visited[u]){
            return;
        }
        visited[u] = true;
        for(int v : revAdj.get(u)){
            if(!visited[v]){
                DFS(v, visited, revAdj);
            }
        }
    }
    
    public void topoDFS(int u, boolean[] visited, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj){
        if(visited[u]){
            return ;
        }
        visited[u] = true;
        for(int v : adj.get(u)){
            if(!visited[v]){
                topoDFS(v,visited, st, adj);
            }
        }
        st.push(u);
    }
}