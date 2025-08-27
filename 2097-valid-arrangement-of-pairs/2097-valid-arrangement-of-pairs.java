class Solution {
    public int[][] validArrangement(int[][] pairs) {
        
        HashMap<Integer, Deque<Integer>> adj = new HashMap<>();
        HashMap<Integer, Integer> inDegree = new HashMap<>();
        HashMap<Integer, Integer> outDegree = new HashMap<>();
        for(int[] pair :pairs){
            int u = pair[0];
            int v = pair[1];
            if(adj.get(u) == null){
                adj.put(u, new ArrayDeque<>());
            }
            adj.get(u).add(v);
            inDegree.put(v, inDegree.getOrDefault(v,0)+1);
            outDegree.put(u, outDegree.getOrDefault(u,0)+1);
        }
        int start = pairs[0][0];
        for(int tmp : outDegree.keySet()){
            if(outDegree.get(tmp) - inDegree.getOrDefault(tmp,0) == 1){
                start = tmp;
                break;
            }
        }
        List<Integer> res = new ArrayList<>();
        
        DFS(start, adj, res);
        // System.out.println(res);
        int[][] answer = new int[pairs.length][2];
        int idx = 0;
        for (int i = res.size() - 1; i > 0; i--) {
            answer[idx++] = new int[]{res.get(i), res.get(i - 1)};
        }

        return answer;

       

    }
    public void DFS(int u, HashMap<Integer, Deque<Integer>> adj, List<Integer> res){
        
        
        
        
        Deque<Integer> tmp = adj.getOrDefault(u, new ArrayDeque<>());
        while(!tmp.isEmpty()){
            int v = tmp.poll();
            DFS(v,adj,res);
        }
        res.add(u);
    }
}