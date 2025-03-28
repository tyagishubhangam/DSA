class Solution {
    public int[] searchRange(int[] arr, int target) {
        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        int n = arr.length;
        int l = 0;
        int r = n - 1;
        int mid = (l+r)/2;
        while(l<=r){
            mid = (l+r)/2;
            if(arr[mid] == target){
                if(mid == 0){
                    ans[0] = 0;
                    break;
                }else{
                    if(arr[mid-1] != arr[mid]){
                        ans[0] = mid;
                        break;
                    }else{
                        r = mid - 1;
                    }
                }
            }else{
                if(arr[mid]< target){
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }
        }

        l = 0;
        r = n - 1;
        mid = (l+r)/2;
        while(l<=r){
            mid = (l+r)/2;
            if(arr[mid] == target){
                if(mid == n-1){
                    ans[1] = n - 1;
                    break;
                }else{
                    if(arr[mid] != arr[mid + 1]){
                        ans[1] = mid;
                        break;
                    }else{
                        l = mid + 1;
                    }
                }
            }else{
                if(arr[mid] < target){
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }
        }
        return ans;
    }
}