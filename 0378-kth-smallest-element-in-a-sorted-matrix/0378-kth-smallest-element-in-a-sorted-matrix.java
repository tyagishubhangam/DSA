class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int min = matrix[0][0];
        int max = matrix[matrix.length - 1][matrix.length - 1];
        int ans = 0;
        
    // System.out.println(max+"<->"+ min);
        int l = min;
        int r = max;
        int mid = (l + r) / 2;
        while(l <= r){
            mid = (l + r) / 2;
            int cnt = getCount(matrix,mid);
            // System.out.println(mid +"->" + cnt);
            if(cnt < k){
                l = mid + 1;
            }else{
                if(getCount(matrix, mid - 1) < k){
                    ans = mid;
                    break;
                }else{
                    r = mid - 1;
                }
            }
        }
        return ans;

    }

    public static int getCount(int[][] matrix, int m){
        int cnt = 0;
        for(int i=0;i<matrix.length;i++){
            int[] arr = matrix[i];
            int l = 0;
            int r = arr.length - 1;
            int mid = (l + r) / 2;
            if(arr[arr.length - 1] <= m){
                cnt += arr.length;
            }else{
                while(l<=r){
                    mid = (l + r) / 2;
                    if(arr[mid] <= m){
                        l = mid + 1;
                    }else{
                        if(mid != 0 && arr[mid - 1] <= m){
                            cnt += mid;
                            break;
                        }else{
                            r = mid - 1;
                        }
                    }
                }
            }
        }
        return cnt;
        
    }
}