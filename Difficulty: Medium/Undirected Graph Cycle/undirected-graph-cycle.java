class Solution {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        HashMap<Integer, List<Integer>> hs = new HashMap<>();
        for(int i=0;i<V;i++){
            hs.put(i,new ArrayList<Integer>());
        }
        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];
            
            hs.get(u).add(v);
            hs.get(v).add(u);
            
            
        }
        boolean[] visited = new boolean[V];
        
        for(int i=0;i<V;i++){
            if(!visited[i] && checkCycle(hs,i,-1,visited)){
                return true;
            }
        }
        
        return false;
    }
    
    public static boolean checkCycle(HashMap<Integer, List<Integer>> hs , int u, int parent,boolean[] visited){
        
        visited[u] = true;
        
        for(int v:hs.get(u)){
            if( parent == v){
                continue;
            }
            if(visited[v]){
                return true;
            }
            if(checkCycle(hs,v,u,visited)){
                return true;
            }
            
        }
        return false;
    }
}