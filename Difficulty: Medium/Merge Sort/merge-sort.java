class Solution {

    void mergeSort(int arr[], int l, int r) {
        if(l == r){
            return;
        }
        // code here
        int mid = l + (r - l) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid+1, r);
        merge(arr, l, mid, r);
    }
    
    public static void merge(int[] arr, int l, int mid, int r){
        
        int s1 = mid - l + 1;
        int s2 = r - mid;
        int[] left = new int[s1];
        int[] right = new int[s2];
        int k = 0;
        for(int i=l;i<=mid;i++){
            left[k] = arr[i];
            k++;
        }
        k = 0;
        for(int i=mid+1;i<=r;i++){
            right[k] = arr[i];
            k++;
        }
        int idx = l;
        int i = 0;
        int j = 0;
        while(i < s1 && j< s2){
            if(left[i] > right[j]){
                arr[idx] = right[j];
                j++;
            }else{
                arr[idx] = left[i];
                i++;
            }
            idx++;
        }
        
        while(i < s1){
            arr[idx++] = left[i++];
        }
        while(j < s2){
            arr[idx++] = right[j++];
        }
    }
}