class Solution {
    public static int MOD = ((int)1e9) + 7;
    public int countPaths(int n, int[][] roads) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:roads){
            int u = edge[0];
            int v = edge[1];
            int dist = edge[2];
            adj.get(u).add(new Pair(dist,v));
            adj.get(v).add(new Pair(dist,u));
        }
        long[] minDistances= new long[n];
        int[] ways = new int[n];
        Arrays.fill(minDistances, Long.MAX_VALUE);
        minDistances[0] = 0;
        ways[0] = 1;
        PriorityQueue<Pair> pq = new PriorityQueue<>(new SortThePQ());
        pq.add(new Pair(0,0));
       
        while(!pq.isEmpty()){
            Pair tmp = pq.poll();
            long dist = tmp.first;
            int u = tmp.second;
            for(Pair p:adj.get(u)){
                int v = p.second;
                long nD = p.first + dist;
                if(nD < minDistances[v]){
                    minDistances[v] = nD;
                    pq.add(new Pair(nD,v));
                    ways[v] = ways[u];
                }else{
                    if(nD == minDistances[v]){
                        ways[v] = (ways[u]%MOD + ways[v]%MOD)%MOD;
                    }
                }
                
            }
        }
        return ways[n-1]%MOD;

        
    }
}

class Pair{
    long first;
    int second;
    Pair(long first, int second){
        this.first = first;
        this.second = second;
    }
}

class SortThePQ implements Comparator<Pair>{
    public int compare(Pair p1, Pair p2){
        if(p1.first == p2.first){
            return p1.second - p2.second;
        }
        return Long.compare(p1.first ,p2.first);
    }
}