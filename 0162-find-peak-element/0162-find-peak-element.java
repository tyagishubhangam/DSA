class Solution {
    public int findPeakElement(int[] arr) {
        int n = arr.length;
        if(n == 1){
            return 0;
        }
        int l = 0;
        int r = n - 1;
        int mid = (l + r)/2;
        while(l<=r){
            mid = (l+r)/2;
            if(mid == 0 ){
                if(arr[mid]>= arr[mid+1])
                {return 0;}
                else{
                    l+=1;
                }
            }else{
                if(mid == n-1 ){
                    if(arr[mid] >= arr[mid - 1]){
                        return n-1;
                    }else{
                        r -=1;
                    }
                    
                }else{
                    if(arr[mid] >= arr[mid+1] && arr[mid] >= arr[mid-1]){
                        return mid;
                    }else{
                        if(arr[mid]<arr[mid-1]){
                            r = mid - 1;
                        }else{
                            l = mid + 1;
                        }
                    }
                }
            }
        }
        return mid;
    }
}