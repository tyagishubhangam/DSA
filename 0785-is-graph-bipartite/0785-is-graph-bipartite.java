class Solution {
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int[] color = new int[V];
        Arrays.fill(color, -1);
        for(int i=0;i<V;i++){
            if(color[i] == -1 && !DFS(graph, i, 0,color)){
                return false;
            }
        }
        return true;
    }

    public static boolean DFS(int[][] graph, int u, int currColor, int[] color){      color[u] = currColor;
        
        for(int v : graph[u]){
            if(v == u){
                continue;
            }
            if(color[v] == currColor){
                return false;
            }
            if(color[v] == -1 && !DFS(graph, v,1 - currColor, color)){
                return false;
            }
            

        }

        return true;


    }
}