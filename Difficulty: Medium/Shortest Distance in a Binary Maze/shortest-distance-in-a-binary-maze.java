// User function Template for Java

class Solution {

    int shortestPath(int[][] grid, int[] source, int[] destination) {

        // Your code here
        
        if(grid[source[0]][source[1]] == 0 || grid[destination[0]][destination[1]]==0 ){
            return -1;
        }
        int rows = grid.length;
        int columns = grid[0].length;
        
        int[][] dist = new int[rows][columns];
        for(int i=0;i<rows;i++){
            Arrays.fill(dist[i],(int)1e9);
        }
        dist[source[0]][source[1]] = 0;
        PriorityQueue<Node> pq =new PriorityQueue<>(new SortThePQ());
        pq.add(new Node(0,source[0],source[1]));
        int[][] options = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!pq.isEmpty()){
            Node tmp = pq.poll();
            int w = tmp.w;
            int r = tmp.i;
            int c = tmp.j;
            for(int x[]:options){
                int nr = r+x[0];
                int nc = c+x[1];
                if(nr>=0 && nc >=0 && nr<rows && nc<columns && grid[nr][nc] != 0){
                    int nw = w + 1;
                    if(nw<dist[nr][nc]){
                        dist[nr][nc] = nw;
                        pq.add(new Node(nw,nr,nc));
                    }
                }
            }
            
        }
        
        if(dist[destination[0]][destination[1]] == (int)1e9){
            return -1;
        }
        
        return dist[destination[0]][destination[1]];
        
        
        
    }
}

class Node{
    int w;
    int i;
    int j;
    Node(int w, int i, int j){
        this.w =w;
        this.i = i;
        this.j = j;
    }
}

class SortThePQ implements Comparator<Node>{
    public int compare(Node a, Node b){
        return a.w - b.w;
    }
}
