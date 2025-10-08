class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0;
        int r = m-1;
        while(l <= r){
            int mid = l + (r-l) / 2;
            if(matrix[mid][0] == target){
                return true;
            }
            if(matrix[mid][0] < target){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }

        if(r < 0 ){
            return false;
        }
        int lr = 0;
        int rr = n-1;
        while(lr <= rr){
            int mid = lr + (rr-lr)/2;
            if(matrix[r][mid] == target){
                return true;
            }
            if(matrix[r][mid] < target){
                lr = mid + 1;
            }else{
                rr = mid -1;
            }
        }
    return false;
    }
}