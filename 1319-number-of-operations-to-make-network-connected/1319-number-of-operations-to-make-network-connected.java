class Solution {
    int[] rank;
    int[] parent;
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1){
            return -1;
        }
        rank = new int[n];
        parent = new int[n];
        int components = n;
        int extraWires = 0;
        for(int i=0;i<n;i++){
            parent[i] = i;
        }
        for(int[] connection : connections){
            int a = connection[0];
            int b = connection[1];
            if(find(a) != find(b)){
                union(a, b);
                components--;
            }else{
                extraWires++;
            }
        }
        
        if(extraWires < components-1){
            return -1;
        }

        return components-1;
        
    }

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
            return;
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
}