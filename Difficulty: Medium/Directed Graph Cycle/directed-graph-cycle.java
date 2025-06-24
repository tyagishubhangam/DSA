class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        Queue<Integer> queue = new LinkedList<>();
        int[] inDegree = new int[V];
        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];
            inDegree[v]++;
            adj.get(u).add(v);
        }
        
        for(int i=0;i<V;i++){
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }
        int cnt = 0;
        while(!queue.isEmpty()){
            int u = queue.poll();
            cnt++;
            for(int v:adj.get(u)){
                inDegree[v]--;
                if(inDegree[v] == 0){
                    queue.add(v);
                }
            }
        }
        
        return (V != cnt);
    }
}