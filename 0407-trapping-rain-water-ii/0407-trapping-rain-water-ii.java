class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        PriorityQueue<Helper> pq = new PriorityQueue<>((a,b)->a.ht - b.ht);
        int[][] dirs = {{0,1}, {0,-1},{1,0}, {-1, 0}};
        boolean[][] visited = new boolean[m][n];
        for(int i=0;i<m;i++){
            visited[i][0]= true;
            visited[i][n-1] = true;
            pq.offer(new Helper(heightMap[i][0], i, 0));
            pq.offer(new Helper(heightMap[i][n-1], i, n-1));
        }
        for(int j=0;j<n;j++){
            visited[0][j]= true;
            visited[m-1][j] = true;
            pq.offer(new Helper(heightMap[0][j], 0, j));
            pq.offer(new Helper(heightMap[m-1][j], m-1, j));
        }
        int res = 0;
        while(!pq.isEmpty()){
            Helper tmp = pq.poll();
            int currHt = tmp.ht;
            int i = tmp.i;
            int j = tmp.j;
            for(int[] dir : dirs){
                int i_ = dir[0] + i;
                int j_ = dir[1] + j;
                if(i_ < m && i_ >= 0 && j_ <n && j_ >=0 && !visited[i_][j_]){
                    int waterHt = Math.max(currHt - heightMap[i_][j_], 0);
                    pq.offer(new Helper(Math.max(currHt, heightMap[i_][j_]), i_, j_));
                    visited[i_][j_] = true;
                    res += waterHt;
                }
            }
        }
        return res;
    }
}

class Helper{
    int ht;
    int i; int j;
    Helper(int ht, int i, int j){
        this.ht = ht;
        this.i = i;
        this.j = j;
    }
}