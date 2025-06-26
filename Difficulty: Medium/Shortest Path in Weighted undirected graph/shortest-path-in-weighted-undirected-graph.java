class Solution {
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        //  Code Here.
        List<Integer> res = new ArrayList<>();
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int u = edge[0]-1;
            int v = edge[1]-1;
            int w = edge[2];
            adj.get(u).add(new int[]{w,v});
            adj.get(v).add(new int[]{w,u});
        }
        
        PriorityQueue<Integer[]> pq = new PriorityQueue(new SortThePQ());
        int[] parent = new int[n];
        int[] dist = new int[n];
        
        for(int i=0;i<n;i++){
            parent[i] = i;
            dist[i] = (int)1e9;
        }
        dist[0] = 0;
        pq.add(new Integer[]{0,0});
        
        while(!pq.isEmpty()){
            Integer[] tmp = pq.poll();
            int u = tmp[1];
            int w = tmp[0];
            
            for(int[] demo:adj.get(u)){
                int wChild = demo[0];
                int v = demo[1];
                int newDist = w + wChild;
                if(newDist < dist[v]){
                    dist[v] = newDist;
                    parent[v] = u;
                    pq.add(new Integer[]{dist[v],v});
                }
            }
        }
        
        if(dist[n-1] == (int)1e9){
            res.add(-1);
            return res;
        }
        res.add(dist[n-1]);
        int node = n - 1;
        while(node != 0){
            res.add(1,node+1);
            node = parent[node];
        }
        res.add(1,1);
        // System.out.println(res);
        return res;
        
    }
}

class SortThePQ implements Comparator<Integer[]>{
    public int compare(Integer[] a, Integer[] b){
        if(a[0] == b[0]){
            return a[1] - b [1];
        }
        return a[0] - b[0];
    }
}