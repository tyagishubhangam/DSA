class Solution {
    public int searchInsert(int[] arr, int target) {
        int n = arr.length;
        int l = 0;
        int r = n - 1;
        while(l <= r){
            int mid = (l + r) / 2;
            if(arr[mid] == target){
                return mid;
            }else{
                if(arr[mid] > target){
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }
        }
        if(r<0){
            return 0;
        }else{
            if(l>n){
                return n - 1;
            }else{
                return l;
            }
        }
    }
}