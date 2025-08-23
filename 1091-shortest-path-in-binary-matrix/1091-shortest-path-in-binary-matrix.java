class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        int rows = grid.length;
        int columns = grid[0].length;
        if(grid[0][0] == 1 || grid[rows-1][columns-1]==1){
            return -1;
        }
        if(columns==1 && rows == 1 && grid[0][0]==0){
            return 1;
        }
        PriorityQueue<Node> pq = new PriorityQueue<>(new SortThePQ());
        int[][] options = {{0,1},{0,-1},{1,0},{-1,0},{1,1},{-1,-1},{1,-1},{-1,1}};
        int[][] dist = new int[rows][columns];
        for(int i=0;i<rows;i++){
            Arrays.fill(dist[i],(int)1e9);
        }
        dist[0][0] = 1;
        pq.add(new Node(1,0,0));
        while(!pq.isEmpty()){
            Node node = pq.poll();
            int r = node.i;
            int c = node.j;
            int w = node.weight;
            for(int i=0;i<8;i++){
                int nr = r+options[i][0];
                int nc = c+options[i][1];
                if(nr >=0 && nc >=0 && nr<rows && nc<columns && grid[nr][nc] == 0){
                    int nw = w + 1;
                    if(dist[nr][nc] > nw){
                        dist[nr][nc] = nw;
                        pq.add(new Node(nw,nr,nc));
                    }
                }
            }
        }

        int ans = dist[rows-1][columns-1];
        if(ans == (int)1e9){
            return -1;
        }
        return ans;
    }
}

class Node{
    int weight;
    int i;
    int j;
    Node(int weight, int i, int j){
        this.weight = weight;
        this.i = i;
        this.j = j;
    }
}

class SortThePQ implements Comparator<Node>{
    public int compare(Node a, Node b){
        
        return a.weight - b.weight;
    }
}