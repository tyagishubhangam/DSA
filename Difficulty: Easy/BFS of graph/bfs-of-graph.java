class Solution {
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int n = adj.size();
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        boolean[] visited = new boolean[n];
        queue.offer(0);
        while(!queue.isEmpty()){
            int u = queue.poll();
            res.add(u);
            visited[u] = true;
            for(int v : adj.get(u)){
                if(!visited[v]){
                    queue.offer(v);
                    visited[v] = true;
                }
            }
        }
        return res;
    }
}