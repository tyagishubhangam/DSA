class Solution {
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        List<List<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[V];
        
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            inDegree[edge[1]]++;
        }
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(inDegree[i] == 0){
                queue.offer(i);
            }
        }
        
        while(!queue.isEmpty()){
            int u = queue.poll();
            result.add(u);
            for(int v : adj.get(u)){
                if(inDegree[v] == 0){
                    queue.offer(v);
                }else{
                    inDegree[v]--;
                    if(inDegree[v] == 0){
                        queue.add(v);
                    }
                }
            }
        }
        
        while(!queue.isEmpty()){
            result.add(queue.poll());
        }
        // System.out.println(result);
        
        return result;
    }
    
    
}
