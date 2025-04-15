class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int t = 0;
        int b = n - 1;
        
        while(t<=b){
            int mid = (t + b) / 2;
            int idx = binarySearch(matrix[mid], target);
            if(idx != -1){
                return true;
            }else{
                if(target > matrix[mid][m-1]){
                    t = mid + 1;
                }else{
                    b = mid - 1;
                }
            }
        }
        return false;

        
    }

    public static int binarySearch(int[] arr, int k){
        int l = 0;
        int r = arr.length -1 ;
        while(l<=r){
            int mid = (l + r)/2;
            if(arr[mid] == k){
                return mid;
            }else{
                if(arr[mid] > k){
                    r = mid -1 ;
                }else{
                    l = mid + 1;
                }
            }
        }
        return -1;
    }
}