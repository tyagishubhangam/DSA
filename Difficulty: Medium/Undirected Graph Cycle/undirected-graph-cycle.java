class Solution {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] visited = new boolean[V];
        
        for(int i=0;i<V;i++){
            if(!visited[i] && checkCycleBFS(adj,i,visited)){
                return true;
            }
        }
        
        return false;
    }
    
    public static boolean checkCycleBFS(List<List<Integer>> adj,int u, boolean[] visited){
        visited[u] = true;
        
        Queue<int[]> queue = new LinkedList<>();
       int[] pair = new int[2];
       pair[0] = u;
       pair[1] = -1;
        queue.add(pair);
        
        while(!queue.isEmpty()){
            int[] x = queue.poll();
            int node = x[0];
            int parent = x[1];
            for(int v:adj.get(node)){
                if(parent == v){
                    continue;
                }
                if(visited[v]){
                    return true;
                }
                // Pair<Integer, Integer> tmp = new Pair<>(v,node);
                int[] tmp = new int[2];
                tmp[0] = v;
                tmp[1] = node;
                queue.add(tmp);
                visited[v] = true;
            }
        }
        
        return false;
        
        
        
    }
}