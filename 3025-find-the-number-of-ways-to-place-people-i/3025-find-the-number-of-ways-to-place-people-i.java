class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length;
        int ans = 0;
        for(int i=0;i<n;i++){
            int[] pointA = points[i];
            for(int j =0;j<n;j++){
                int[] pointB = points[j];
                if(i ==  j || !(pointA[0] <= pointB[0] && pointA[1] >= pointB[1])){
                    continue;
                }
                if(n == 2){
                    return 1;
                }
                // Ab agar upar vali conditions se safely aagaya neeche then ab we will check for any point existing inside the rectangle made by pointA and pointB
                boolean isValid = true;
                for(int k=0;k<n;k++){
                    int[] tmp = points[k];
                    if(k == i || k == j){
                        continue;
                    }
                    if(tmp[0] >= pointA[0] && tmp[0] <= pointB[0] && tmp[1] <= pointA[1] && tmp[1] >= pointB[1]){
                        isValid = false;
                        break;
                    }        
                }
                if(isValid){
                    ans++;
                }

            }
        }
        return ans;
    }
}