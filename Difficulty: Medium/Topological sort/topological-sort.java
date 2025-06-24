class Solution {
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }
        
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[V];
        for(int i=0;i<V;i++){
            if(visited[i]){
                continue;
            }
            topoSort(adj,i,visited,st);
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        while(!st.isEmpty()){
            res.add(st.pop());
        }
        
        
        return res;
    }
    
    public static void topoSort(List<List<Integer>> adj, int u, boolean[] visited, Stack<Integer> st){
        if(visited[u]){
            return;
        }
        visited[u] = true;
        for(int v:adj.get(u)){
            if(visited[v]){
                continue;
            }
            if(!visited[v]){
                // st.push(v);
                topoSort(adj,v,visited,st);
            }
        }
        st.push(u);
    }
}