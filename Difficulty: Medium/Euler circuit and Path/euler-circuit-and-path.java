class Solution {
    public int isEulerCircuit(int V, List<Integer>[] adj) {
        // code here
        int[] degree = new int[V];
        boolean[] visited = new boolean[V];
        int toDFS = -1;
        int oddCnt = 0;
        for(int i=0;i<V;i++){
            degree[i] = adj[i].size();
            if(degree[i] > 0){
                toDFS = i;
            }
            if(degree[i] % 2 != 0){
                oddCnt++;
            }
        }
        if(toDFS != -1){
            DFS(toDFS, visited, adj);
        }
        for(int i=0;i<V;i++){
            if(degree[i] > 0 && !visited[i]){
                return 0;
            }
        }
        if(oddCnt == 0){
            return 2;
        }
        if(oddCnt == 2){
            return 1;
        }
        return 0;
        
    }
    public void DFS(int u, boolean[]visited, List<Integer>[] adj){
        if(visited[u]){
            return;
        }
        visited[u] = true;
        for(int v : adj[u]){
            if(!visited[v]){
                DFS(v, visited, adj);
            }
        }
    }
}