class Solution {
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int[] color = new int[V];
        Queue<Integer> queue = new LinkedList<>();
        Arrays.fill(color, -1);

        for(int i=0;i<V;i++){
            if(color[i] == -1 && !checkBipartite(graph, i, 0, color)){
                return false;
            }
        }

        return true;


    }

    public static boolean checkBipartite(int[][] graph, int u, int currColor, int[] color){
        Queue<Integer> queue = new LinkedList<>();
        color[u] = currColor;
        queue.offer(u);
        while(!queue.isEmpty()){
            int pr = queue.poll();
            int prColor = color[pr];
            for(int v : graph[pr]){


                if(prColor == color[v]){
                    return false;
                }
                
                

                
                if(color[v] == -1){
                    color[v] = 1 - prColor;
                    queue.offer(v);
                }
                
            }
        }

        return true;
    }
}