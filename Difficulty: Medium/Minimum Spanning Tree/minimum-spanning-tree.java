class Solution {
    int[] parent;
    int[] rank;
    
    public int find(int x){
        if(parent[x] == x){
            return x;
        }
        
        return parent[x] = find(parent[x]);
    }
    
    public void union(int a, int b){
        int parent_a = find(a);
        int parent_b = find(b);
        if(parent_a == parent_b){
            return ;
        }
        if(rank[parent_a] == rank[parent_b]){
            parent[parent_b] = parent_a;
            rank[parent_a]++;
        }else{
            if(rank[parent_a] > rank[parent_b]){
                parent[parent_b] = parent_a;
            }else{
                parent[parent_a] = parent_b;
            }
        }
    }
    public int spanningTree(int V, int[][] edges) {
        rank = new int[V];
        parent = new int[V];
        for(int i=0;i<V;i++){
            parent[i] = i;
        }
        int result = 0;
       
        Arrays.sort(edges,new SortTheNodes());
        for(int[] tmp : edges){
            int u = tmp[0];
            int v = tmp[1];
            int wt = tmp[2];
            if(find(u) != find(v)){
                union(u,v);
                result += wt;
            }
        }
        return result;
    }
}

class SortTheNodes implements Comparator<int[]>{
    public int compare(int[] a, int[] b){
        return a[2] - b[2];
    }
}
