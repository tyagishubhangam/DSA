class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        int i = 0;
        int j = 0;
        // sorting bottom left
        int row = 0;
        while(row < n){
            List<Integer> li = new ArrayList<>();
            i = row;
            j = 0;
            while(i < n && j < n){
                li.add(grid[i][j]);
                i++;
                j++;
            }
            Collections.sort(li);
            // System.out.println(li);
            i--;
            j--;
            int idx = 0;
            while(i >=0 && j >= 0){
                grid[i][j] = li.get(idx);
                i--;
                j--;
                idx++;
            }
            
           
            row++;
        }

        // sorting top right
        int col = 1;
        while(col < n){
            List<Integer> li = new ArrayList<>();
            i = 0;
            j = col;
            while(i< n && j < n){
                li.add(grid[i][j]);
                i++;
                j++;
            }
            i--;
            j--;
            Collections.sort(li);
            int idx = li.size()-1;
            while(i>=0 && j >= 0){
                grid[i][j] = li.get(idx);
                idx--;
                i--;
                j--;
            }
            col++;
        }
        return grid;
    }
}