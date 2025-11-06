class Solution {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        int n = connections.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<=c;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] connection : connections){
            int u = connection[0];
            int v = connection[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        HashMap<Integer, TreeSet<Integer>> hs = new HashMap<>();
        int[] visited = new int[c+1];
        
        Arrays.fill(visited, -1);
        for(int i=1;i<=c;i++){
            if(visited[i] == -1){
                DFS(i,i,visited,hs, adj);
            }
        }
        List<Integer> li = new ArrayList<>();
        for(int[] query : queries){
            int parent = visited[query[1]];
            if(query[0] == 2){
                hs.get(parent).remove(query[1]);
                continue;
            }
            if(hs.get(parent).contains(query[1])){
                li.add(query[1]);
                continue;
            }
            if(hs.get(parent).isEmpty()){
                li.add(-1);
            }else{
                li.add(hs.get(parent).first());
            }
            
        }
        int[] ans = new int[li.size()];
        for(int i=0;i<li.size();i++){
            ans[i] = li.get(i);
        }
        return ans;

    }

    public void DFS(int i, int parent, int[] visited, HashMap<Integer, TreeSet<Integer>> hs, List<List<Integer>> adj){
        if(visited[i] != -1){
            return ;
        }
        visited[i] = parent;
        if(hs.get(parent) == null){
            hs.put(parent, new TreeSet<>());
        }

        hs.get(parent).add(i);
        for(int v : adj.get(i)){
            if(visited[v] == -1){
                DFS(v,parent,visited,hs,adj);
            }
        }
    }
}