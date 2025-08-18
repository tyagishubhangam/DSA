


class Solution {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        boolean[] visited = new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i] && checkCycleBFS(adj, i, visited)){
                return true;
            }
        }
        
        return false;
        
        
    }
    
    public static boolean checkCycleBFS(List<List<Integer>> adj, int i, boolean[] visited){
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(i, -1));
        visited[i] = true;
        
        while(!queue.isEmpty()){
            Pair node = queue.poll();
            int u = node.u;
            int parent = node.parent;
            
            for(int v : adj.get(u)){
                if(v == parent){
                    continue;
                }
                
                if(visited[v]){
                    return true;
                }
                visited[v] = true;
                queue.offer(new Pair(v, u));
            }
        }
        
        return false;
    }
    
}

class Pair{
    int u;
    int parent;
    Pair(int u, int parent){
        this.u = u;
        this.parent = parent;
    }
}