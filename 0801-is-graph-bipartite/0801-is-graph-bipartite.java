class Solution {
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int[] colorState = new int[V];
        Arrays.fill(colorState,-1);
        for(int i=0;i<V;i++){
            if(colorState[i]== -1 && checkBipartite(graph,i,0,colorState) == false){
                return false;
            }
        }
        
    return true;
    }


    public static boolean checkBipartite(int[][] graph, int U, int currColor, int[] colorState){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(U);
        colorState[U] = 0;

        while(!queue.isEmpty()){
            int u = queue.poll();
            for(int i = 0;i<graph[u].length;i++){
                int v = graph[u][i];
                if(colorState[v] == colorState[u]){
                    return false;
                }

                if(colorState[v] == -1){
                    colorState[v] = 1 - colorState[u];
                    queue.add(v);
                }
            }
        }

        return true;
    }
}