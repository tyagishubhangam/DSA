class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        if(originalColor == color){
            return image;
        }
        recurse(image, sr,sc,color,originalColor);
        return image;
    }

    public static void recurse(int[][]image, int i, int j, int color, int originalColor){
        if(i < 0 || i >=image.length){
            return;
        }

        if(j < 0 || j >= image[0].length){
            return ;
        }

        if(image[i][j] != originalColor){
            return;
        }
        image[i][j] = color;
        int[][] choices = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};

        for(int[] choice : choices){
            recurse(image, i+choice[0], j + choice[1],color,originalColor);
        }


    }
}