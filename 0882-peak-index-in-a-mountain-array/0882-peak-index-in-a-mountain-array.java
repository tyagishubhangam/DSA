class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int l = 0;
        int r = n-1;
        while(l<=r){
            int mid = (l + r) / 2;
            if(mid == 0){
                if(arr[mid] > arr[mid + 1]){
                    return 0;
                }else{
                    l = mid + 1;
                }
            }else{
                if(mid == n - 1){
                    if(arr[mid] > arr[mid - 1]){
                        return mid;
                    }else{
                        r = mid -1;
                    }
                }else{
                    if(arr[mid] >arr[mid -1] && arr[mid] > arr[mid + 1]){
                        return mid;
                    }else{
                        if(arr[mid-1]<= arr[mid +1]){
                            l = mid +1;
                        }else{
                            r = mid -1;
                        }
                    }
                }
            }
        }
        return 0;
    }
}