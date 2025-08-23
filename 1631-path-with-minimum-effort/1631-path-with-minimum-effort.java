class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int columns = heights[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new SortThePQ());
        int[][] minEfforts = new int[rows][columns];
        for(int i=0;i<rows;i++){
            Arrays.fill(minEfforts[i], (int)1e8);
        }
        minEfforts[0][0] = 0;
        int[][] options = new int[][]{
            {0,1},{1,0},{-1,0},{0,-1}
        };
        pq.offer(new int[]{0,0,0});
        while(!pq.isEmpty()){
            int[] tmp = pq.poll();
            int ht = heights[tmp[1]][tmp[2]];
            for(int[] option : options){
                
                int i = tmp[1] + option[0];
                int j = tmp[2] + option[1];
                if(i>=0 && i < rows && j >=0 && j < columns){
                    int diff = Math.max(tmp[0],Math.abs(ht - heights[i][j]));
                    if(diff < minEfforts[i][j]){
                        minEfforts[i][j] = diff;
                        pq.offer(new int[]{diff,i,j});
                    }
                }
            }

        }

        return minEfforts[rows-1][columns-1];
    }
}

class SortThePQ implements Comparator<int[]>{
    public int compare(int[] a, int[] b){
        return a[0] - b[0];
    }
}