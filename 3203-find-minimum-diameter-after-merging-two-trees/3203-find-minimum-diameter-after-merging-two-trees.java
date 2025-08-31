class Solution {
    public List<List<Integer>> getAdj(int[][] edges){
        int n = edges.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        return adj;
    }
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        List<List<Integer>> adj1 = getAdj(edges1);
        List<List<Integer>> adj2 = getAdj(edges2);
        int d1 = getDiameter(adj1);
        int d2 = getDiameter(adj2);
        int combined = (int)Math.ceil(d1/2.0) +(int) Math.ceil(d2/2.0)+ 1;
        // System.out.println("d1-"+Math.ceil(d1/2)+". d2-"+Math.ceil(d2/2)+". combined-"+combined);
        int minDia = Math.max(combined, Math.max(d1,d2)); 


        return minDia;
    }

    public int getDiameter(List<List<Integer>> adj){
        boolean[] visited = new boolean[adj.size()+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;
        int dist = 0;
        int tmpNode = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                int u = queue.poll();
                tmpNode = u;
                for(int v : adj.get(u)){
                    if(!visited[v]){
                        queue.offer(v);
                        visited[v] = true;
                    }
                }

            }
            
            
        }

        Arrays.fill(visited, false);
        queue.offer(tmpNode);
        visited[tmpNode] = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                int u = queue.poll();
                for(int v : adj.get(u)){
                    if(!visited[v]){
                        queue.offer(v);
                        visited[v] = true;
                    }
                }
            }
            if(!queue.isEmpty()){
                dist++;
            }
        }

        return dist;
    }
}