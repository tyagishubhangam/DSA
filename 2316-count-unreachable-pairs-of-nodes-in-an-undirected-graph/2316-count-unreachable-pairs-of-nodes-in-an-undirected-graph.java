class Solution {
    int[] parent;
    int[] rank;
    public int find(int a){
        if(a == parent[a]){
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    public void union(int a, int b){
        int prt_a = find(a);
        int prt_b = find(b);
        if(prt_a == prt_b){
            return ;
        }
        if(rank[prt_a] == rank[prt_b]){
            rank[prt_a]++;
            parent[prt_b] = prt_a;
        }else{
            if(rank[prt_a] > rank[prt_b]){
                parent[prt_b] = prt_a;
            }else{
                parent[prt_a] = prt_b;
            }
        }
        
    }
    public long countPairs(int n, int[][] edges) {
        parent = new int[n];
        rank = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
        }
        HashMap<Integer, Long> hm = new HashMap<>();
        for(int[] edge : edges){
            int a = edge[0];
            int b = edge[1];
            union(a,b);
        }

        for(int i=0;i<n;i++){
            int prt = find(i);
            hm.put(prt, hm.getOrDefault(prt,0l)+1);
        }
        // System.out.println(hm);
        long result = 0;
        int remComponents = n;
        for(int prt : hm.keySet()){
            long size = hm.get(prt);
            result += size * (remComponents - size);
            remComponents -= size;
        }

        return result;
    }
}