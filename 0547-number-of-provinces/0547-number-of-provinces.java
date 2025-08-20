class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int cnt = 0;
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                DFS(isConnected, i, visited);
                cnt++;
            }
        }
        return cnt;

    }

    public static void DFS(int[][] isConnected, int u, boolean[] visited){
        if(visited[u]){
            return;
        }
        visited[u] = true;

        for(int v=0;v<isConnected[u].length;v++){
            if(u != v){
                if(isConnected[u][v] == 1 && !visited[v]){
                    DFS(isConnected, v, visited);
                }
            }
        }
    }
}