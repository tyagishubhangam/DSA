// User function template for JAVA

class Solution {
    public void floydWarshall(int[][] dist) {
        // Code here
        int n = dist.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    if(dist[j][i] < (int)1e8 && dist[i][k] < (int)1e8){
                        dist[j][k] = Math.min(dist[j][k], dist[j][i] + dist[i][k]);
                    }
                }
            }
        }
    }
}